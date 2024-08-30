package com.projects.codility.hard;

import org.springframework.stereotype.Service;

/*
A non-negative integer N is called sparse if its binary representation does not contain two consecutive bits set to 1. For example, 41 is sparse, because its binary representation is "101001" and it does not contain two consecutive 1s. On the other hand, 26 is not sparse, because its binary representation is "11010" and it contains two consecutive 1s.

Two non-negative integers P and Q are called a sparse decomposition of integer N if P and Q are sparse and N = P + Q.

For example:

8 and 18 are a sparse decomposition of 26 (binary representation of 8 is "1000", binary representation of 18 is "10010");
9 and 17 are a sparse decomposition of 26 (binary representation of 9 is "1001", binary representation of 17 is "10001");
2 and 24 are not a sparse decomposition of 26; though 2 + 24 = 26, the binary representation of 24 is "11000", which is not sparse.
Write a function:

class Solution { public int solution(int N); }

that, given a non-negative integer N, returns any integer that is one part of a sparse decomposition of N. The function should return −1 if there is no sparse decomposition of N.

For example, given N = 26 the function may return 8, 9, 17 or 18, as explained in the example above. All other possible results for N = 26 are 5, 10, 16 and 21.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000,000].
 */
@Service
public class SparseBinaryDecomposition {
        // Complexity O(log(N)) or O(1)
        public int solution(int N) {
            // Implement your solution here
            if(N==0) return 0;
            if(N==1) return 1;

            String binary = Integer.toBinaryString(N);
            boolean isOne = isOneOne(binary);

            if(isOne) {
                int power = binary.length();

                // System.out.println("bin: " + binary);

                return (int) Math.pow(2,power-2);
            }
            else {
                String sparse = takeSparse(binary);

                // System.out.println("bin: " + binary);
                // System.out.println("sparse: " + sparse);

                return Integer.parseInt(sparse, 2);
            }

            // return -1;
        }

        public
        String takeSparse(String binary) {
            boolean nextOne = true;
            StringBuilder inputBuilder = new StringBuilder("");
            for(int i=0;i<binary.length();i++) {
                if(nextOne && binary.charAt(i)=='1') {
                    nextOne=false;
                    inputBuilder.insert(i, '1');
                } else {
                    inputBuilder.insert(i, '0');
                    nextOne=true;
                }
            }
            return inputBuilder.toString();
        }

        private boolean isOneOne(String binary) {
            int count = 0;
            for(int i=0;i<binary.length();i++) {
                if(binary.charAt(i) == '1') {
                    count++;
                }
                if(count>1) {
                    return false;
                }
            }
            return true;
        }
}