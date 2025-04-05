package com.projects.codility.hard;
import java.util.Deque;
import java.util.LinkedList;

public class DisappearingPairs {
    // you can also use imports, for example:
// import java.util.*;import java.util.Deque;
//import java.util.LinkedList;
//Deque<Character> stack = new LinkedList<>();

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    // PERFOMANCE - O(N)
    public String solutionStack(String S) {
        // Implement your solution here

        Deque<Character> stack = new LinkedList<>();

        for(int i=0;i<S.length();i++) {
            if(stack.size()>0 && stack.peekLast()==S.charAt(i)) {
                stack.pollLast();
            } else {
                stack.offerLast(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        // Iterate through the Deque and append each character to the StringBuilder
        for (Character c : stack) {
            sb.append(c);
        }

        // Convert StringBuilder to String and return
        return sb.toString();

    }

    // PERFOMANCE - O(N**2)
    public String solutionRecursive(String S) {
            // Implement your solution here

            String res = "";

            res = recursiveFun(S);

            return res;
        }

        public String recursiveFun(String S) {

            String res = "";

            if(S.length()>1) {
                String left = recursiveFun(S.substring(0, (S.length()/2)));
                String right = recursiveFun(S.substring(S.length()/2));

                while(left.length()>0 && right.length()>0 && left.charAt(left.length()-1)==right.charAt(0)) {
                    left = left.substring(0,left.length()-1);
                    right = right.substring(1);
                }

                return left+right;
            } else {
                return S;
            }
        }
    }