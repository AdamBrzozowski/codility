package com.projects.codility.easy;

public class ArrayListLen {
        public int solution(int[] A) {
            // Implement your solution here
            int len = 0;

            int arrayValuePosition = 0;
            while(arrayValuePosition!=-1) {
                arrayValuePosition = A[arrayValuePosition];
                len++;
            }

            return len;
        }

}
