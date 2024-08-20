package com.projects.codility.medium;

import org.springframework.stereotype.Service;

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
