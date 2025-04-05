package com.projects.codility.test;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Calculate the balance at the end of the year for a bank account.
 *
 * Parameters:
 *   - A: Array of transaction amounts (negative values represent payments).
 *   - D: Array of transaction dates in yyyy-MM-dd format.
 *
 * Rule:
 *   - A $5 monthly card fee is applied if there are fewer than 3 payments, or the total of those payments is less than $100 in any given month.
 */
@Service
public class BankTransactions {
        public int solution(int[] A, String[] D) {
            // Implement your solution here
            int[] monthsTot = new int[12];
            int[] monthsPay = new int[12];
            int result = 0;

            int transactionAmount=0;
            String dateString = "";
            LocalDate date;
            int month;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for(int i=0; i<A.length; i++) {
                transactionAmount=A[i];
                result+=transactionAmount;

                date = LocalDate.parse(D[i], formatter);

                month = date.getMonthValue();


                if(transactionAmount<0) {
                    monthsTot[month-1]+=transactionAmount;
                    monthsPay[month-1]+=1;
                }
            }

            for(int i=0; i<12; i++) {
                // System.out.println(monthsPay[i] + " - " + monthsTot[i]);
                if(monthsPay[i]<3 ||  monthsTot[i]>-100) {
                    result-=5;
                }
            }

            return result;
        }
}