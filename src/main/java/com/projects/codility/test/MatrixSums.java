package com.projects.codility.test;

import java.util.Arrays;

/*
Return Matrix of 2 rows and N columns of 1s and 0s given:
    - U: sum of all 1s of first row
    - L: sum of all 1s of second row
    - C: array N of sums of 1s for each column
 */
public class MatrixSums {
        public String solution(int U, int L, int[] C) {
            // Implement your solution here
            String result="";

            int sumC= Arrays.stream(C).sum();
            if(sumC != L+U) {
                return "IMPOSSIBLE";
            };

            int minUL=0;
            int M[][] = new int[2][C.length];
            int sumFirst=0;
            int sumSecond=0;
            String M1="";
            String M2="";
            for(int colSum : C) {
                if(colSum==2) {
                    minUL++;
                    sumFirst++;
                    sumSecond++;
                    M1 = M1 + "1";
                    M2 = M2 + "1";
                } else if(colSum==0) {
                    M1 = M1 + "0";
                    M2 = M2 + "0";
                } else if(sumFirst<U) {
                    sumFirst++;
                    M1 = M1 + "1";
                    M2 = M2 + "0";
                } else if(sumSecond<L) {
                    sumSecond++;
                    M1 = M1 + "0";
                    M2 = M2 + "1";
                } else {
                    return "IMPOSSIBLE";
                }

                if(U<minUL || L<minUL) {
                    return "IMPOSSIBLE";
                }
            }

            return M1+","+M2;
        }
}
