package com.projects.codility.medium;

import org.springframework.stereotype.Service;

/*
In this problem we consider unsigned 30-bit integers, i.e. all integers B such that 0 ≤ B < 230.

We say that integer A conforms to integer B if, in all positions where B has bits set to 1, A has corresponding bits set to 1.

For example:

00 0000 1111 0111 1101 1110 0000 1111(BIN) = 16,244,239 conforms to
00 0000 1100 0110 1101 1110 0000 0001(BIN) = 13,032,961, but
11 0000 1101 0111 0000 1010 0000 0101(BIN) = 819,399,173 does not conform to
00 0000 1001 0110 0011 0011 0000 1111(BIN) = 9,843,471.
Write a function:

class Solution { public int solution(int A, int B, int C); }

that, given three unsigned 30-bit integers A, B and C, returns the number of unsigned 30-bit integers conforming to at least one of the given integers.

For example, for integers:

A = 11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1,073,741,727,
B = 11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1,073,741,631, and
C = 11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1,073,741,679,
the function should return 8, since there are 8 unsigned 30-bit integers conforming to A, B or C, namely:

11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1,073,741,631,
11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1,073,741,679,
11 1111 1111 1111 1111 1111 0111 1111(BIN) = 1,073,741,695,
11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1,073,741,727,
11 1111 1111 1111 1111 1111 1011 1111(BIN) = 1,073,741,759,
11 1111 1111 1111 1111 1111 1101 1111(BIN) = 1,073,741,791,
11 1111 1111 1111 1111 1111 1110 1111(BIN) = 1,073,741,807,
11 1111 1111 1111 1111 1111 1111 1111(BIN) = 1,073,741,823.
Write an efficient algorithm for the following assumptions:

A, B and C are integers within the range [0..1,073,741,823].
 */
@Service
public class CountConformingBitmask {

    public int solution(int A, int B, int C, int bitSize) {
        // Implement your solution here

        int result = 0;
        int small = 0;
        int middle = 0;
        int big = 0;

        small = Math.min(A,B);
        small = Math.min(small,C);

        big = Math.max(A,B);
        big = Math.max(big,C);

        if(A>small && A<big) middle = A;
        else if(B>small && B<big) middle = B;
        else middle = C;

        String binarySmall = Integer.toBinaryString(small);
        String binaryBig = Integer.toBinaryString(big);
        String binaryMiddle = Integer.toBinaryString(middle);

        //STEP 1: count all combinations of binary numbers conforming to the smaller number
        int zeros = zeroCount(binarySmall);
        int diff = bitSize - binarySmall.length();
        int power = zeros + diff;

        result = (int) Math.pow(2,power);

        //STEP 1: count all combinations of binary numbers conforming to the middle number
        //it may include binary numbers already counted go to STEP 3
        zeros = zeroCount(binaryMiddle);
        diff = bitSize - binaryMiddle.length();
        power = zeros + diff;

        result += (int) Math.pow(2,power);

        //STEP 3: count all combinations of binary numbers conforming to both the middle and the smaller number and subtract from the final count
        int zerosCommon = zeroCommonCount(binarySmall, binaryMiddle,bitSize);
        result -= (int) Math.pow(2,zerosCommon);


        //STEP 4: count all combinations of binary numbers conforming to the bigger number
        //it may include binary numbers already counted go to STEP 5 and 6
        zeros = zeroCount(binaryBig);
        diff = bitSize - binaryBig.length();
        power = zeros + diff;

        result += (int) Math.pow(2,power);

        //STEP 5: count all combinations of binary numbers conforming to both the bigger and the smaller number and subtract from the final count
        zerosCommon = zeroCommonCount(binarySmall, binaryBig, bitSize);
        result -= (int) Math.pow(2,zerosCommon);

        //STEP 6: count all combinations of binary numbers conforming to both the bigger and the middle number and subtract from the final count
        //it may include binary numbers already subtracted at STEP 5 go to STEP 7
        zerosCommon = zeroCommonCount(binaryMiddle, binaryBig, bitSize);
        result -= (int) Math.pow(2,zerosCommon);

        //STEP 7: count all combinations of binary numbers conforming to ALL the bigger, the middle and the smaller number and add them again to the final count
        zerosCommon = zeroCommonAllCount(binarySmall, binaryBig, binaryMiddle, bitSize);
        result += (int) Math.pow(2,zerosCommon);


        return result;
    }

    public int zeroCount(String binary) {
        int zeroCount = 0;
        for(int i=0;i<binary.length();i++) {
            if(binary.charAt(i)=='0') {
                zeroCount++;
            }
        }
        return zeroCount;
    }

    public int zeroCommonCount(String binarySmaller,String binaryBigger, int size) {
        int zeroCount = 0;
        binarySmaller = padZero(binarySmaller,size);
        binaryBigger = padZero(binaryBigger,size);
        for(int i=0;i<binarySmaller.length();i++) {
            if(binarySmaller.charAt(i)=='0' && binaryBigger.charAt(i)=='0') {
                zeroCount++;
            }
        }
        return zeroCount;
    }

    public int zeroCommonAllCount(String binarySmaller,String binaryBigger,String binaryMiddle, int size) {
        int zeroCount = 0;
        binarySmaller = padZero(binarySmaller,size);
        binaryBigger = padZero(binaryBigger,size);
        binaryMiddle = padZero(binaryMiddle,size);
        for(int i=0;i<binarySmaller.length();i++) {
            if(binarySmaller.charAt(i)=='0' && binaryBigger.charAt(i)=='0' && binaryMiddle.charAt(i)=='0') {
                zeroCount++;
            }
        }
        return zeroCount;
    }

    private String padZero(String input, int size) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length()<size) {
            inputBuilder.insert(0, '0');
        }
        input = inputBuilder.toString();
        return input;
    }
}
