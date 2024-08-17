package com.projects.codility.easy;

import org.springframework.stereotype.Service;

@Service
public class BinaryGap {
    public int solution(int N) {
        // Implement your solution here
        String binaryRepresentation = Integer.toBinaryString(N);
        int result = 0;
        int count = 0;
        boolean start = false;
        for (int i=0;i<binaryRepresentation.length();i++) {
            Character binaryElem = binaryRepresentation.charAt(i);
            if (binaryElem.equals('1')) {
                if (start) {
                    if (count > result) result = count;
                    count = 0;
                } else {
                    start = true;
                }
            }
            if (binaryElem.equals('0') && start) {
                count++;
            }
        }

        return result;
    }
}
