package com.projects.codility.test;

import org.springframework.stereotype.Service;

/*
 * Calculate the number of families of 4 that can be seated on a plane with N rows, where each row has:
 *   - 3 seats on the left (A, B, C),
 *   - 4 seats in the center (D, E, F, G),
 *   - 3 seats on the right (H, J, K).
 *
 * Seating rules:
 *   - The family must sit together in adjacent seats.
 *   - If separated by a corridor, the family must be split with 2 members on one side and 2 on the other.
 *
 * Parameters:
 *   - N: Number of rows on the plane.
 *   - S: List of reserved seats in the format ("2A", "23B", "2F", "12H", "11C", ...).
 */
@Service
public class PlaneReservations {

        public int solution(int N, String S) {
            // Implement your solution here
            int result = 0;
            String[] reservations = S.split(" ");

            int[][] seats = new int[N][10];

            int rowNum;
            int letterNum=0;
            for(String res : reservations) {
                if(S.length()>1) {
                    char letter = res.charAt(res.length()-1);
                    String rowRes = res.substring(0,res.length()-1);
                    // System.out.println(letter + " - " + rowRes);
                    rowNum = Integer.parseInt(rowRes);

                    switch(letter) {
                        case 'A':
                            letterNum=1;
                            break;
                        case 'B':
                            letterNum=2;
                            break;
                        case 'C':
                            letterNum=3;
                            break;
                        case 'D':
                            letterNum=4;
                            break;
                        case 'E':
                            letterNum=5;
                            break;
                        case 'F':
                            letterNum=6;
                            break;
                        case 'G':
                            letterNum=7;
                            break;
                        case 'H':
                            letterNum=8;
                            break;
                        case 'J':
                            letterNum=9;
                            break;
                        case 'K':
                            letterNum=10;
                            break;
                    }

                    seats[rowNum-1][letterNum-1] = 1;
                }
            }

            int free=0;
            for(int row=0; row<N; row++) {
                free=0;
                for(int col=0; col<10;col++) {
                    if(free<2 && col==3) {
                        free=0;
                    } else if (free>2 && col==3) {
                        free=2;
                    }

                    if(free<2 && col==7) {
                        free=0;
                    } else if (free>2 && col==7) {
                        free=2;
                    }

                    if(seats[row][col]==0) {
                        free+=1;
                    } else {
                        free=0;
                    }

                    if(free==4) {
                        result+=1;
                        free=0;
                    }

                }
            }

            return result;
        }
}
