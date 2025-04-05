package com.projects.codility.test;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/*
 * Return a matrix with 2 rows and N columns filled with 1s and 0s, based on the following parameters:
 *
 * Parameters:
 *   - U: The total sum of 1s in the first row.
 *   - L: The total sum of 1s in the second row.
 *   - C: An array of length N representing the sum of 1s in each column.
 */
@Service
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
                if (colSum == 2) {
                    minUL++;
                    sumFirst++;
                    sumSecond++;
                    M1 = M1 + "1";
                    M2 = M2 + "1";
                } else {
                    M1 = M1 + "0";
                    M2 = M2 + "0";
                }
            }

            if(U<minUL || L<minUL) {
                return "IMPOSSIBLE";
            }

            for(int i=0; i<C.length; i++) {
                if(C[i]==2) {
                    continue;
                }
                if(C[i]==0) {
                    M1 = M1.substring(0, i) + "0" + M1.substring(i + 1);
                    M2 = M2.substring(0, i) + "0" + M2.substring(i + 1);
                } else if(sumFirst<U) {
                    sumFirst++;
                    M1 = M1.substring(0, i) + "1" + M1.substring(i + 1);;
                    M2 = M2.substring(0, i) + "0" + M2.substring(i + 1);
                } else if(sumSecond<L) {
                    sumSecond++;
                    M1 = M1.substring(0, i) + "0" + M1.substring(i + 1);
                    M2 = M2.substring(0, i) + "1" + M2.substring(i + 1);
                } else {
                    return "IMPOSSIBLE";
                }
            }

            return M1+","+M2;
        }
}
