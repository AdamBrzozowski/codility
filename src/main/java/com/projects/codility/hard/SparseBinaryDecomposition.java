package com.projects.codility.hard;

import org.springframework.stereotype.Service;

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