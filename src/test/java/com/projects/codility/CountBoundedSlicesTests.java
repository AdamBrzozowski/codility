package com.projects.codility;

import com.projects.codility.medium.CountBoundedSlices;
import com.projects.codility.medium.CountConformingBitmask;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class CountBoundedSlicesTests {

	@Autowired
	private CountBoundedSlices countBoundedSlices;

	@Test
	void countBoundedSlicesTest() {
		int MAX_ARRAY_SIZE = 100000;
		int MAX_K = 1000000000;
		int MAX_ARRAY_VALUES = 1000000000;

		ArrayList<Assertion> assertions = new ArrayList<>();

		Random rand = new Random();


		assertions.add(execute(2,new int[]{2, 3, 4, 1, 2, 3, 7, 1, 4, 3, 8, 2, 1, 0, 3, 8, 6, 7, 5, 4, 7, 2, 4, 3, 8, 4, 3, 5, 0, 1, 6, 8, 1, 0, 9},1));
		assertions.add(execute(2,new int[]{22},2));
		assertions.add(execute(2,new int[]{1,2},3));
		assertions.add(execute(2,new int[]{1,5},4));
		assertions.add(execute(2,new int[]{1,2,3},5));
		assertions.add(execute(2,new int[]{1,2,10},6));
		assertions.add(execute(2,new int[]{1,10,3},7));


		assertions.add(execute(2, randomArray(10,10, false),8));
		assertions.add(execute(2, randomArray(10,10, true),9));
		assertions.add(execute(rand.nextInt(10), randomArray(10,10, false),10));


		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),11));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),12));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),13));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),14));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),15));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),16));
		assertions.add(execute(rand.nextInt(10), randomArray(MAX_ARRAY_SIZE,rand.nextInt(10), false),17));
		assertions.add(execute(MAX_K, randomArray(MAX_ARRAY_SIZE,rand.nextInt(MAX_ARRAY_VALUES), false),18));

		assertions.add(execute(rand.nextInt(MAX_K), randomArray(rand.nextInt(MAX_ARRAY_SIZE),rand.nextInt(MAX_ARRAY_VALUES), true),19));
		assertions.add(execute(rand.nextInt(MAX_K), randomArray(rand.nextInt(MAX_ARRAY_SIZE),rand.nextInt(MAX_ARRAY_VALUES), true),20));
		assertions.add(execute(rand.nextInt(MAX_K), randomArray(rand.nextInt(MAX_ARRAY_SIZE),rand.nextInt(MAX_ARRAY_VALUES), true),21));
		assertions.add(execute(rand.nextInt(MAX_K), randomArray(rand.nextInt(MAX_ARRAY_SIZE),rand.nextInt(MAX_ARRAY_VALUES), true),22));
		assertions.add(execute(rand.nextInt(MAX_K), randomArray(rand.nextInt(MAX_ARRAY_SIZE),rand.nextInt(MAX_ARRAY_VALUES), true),23));

		assertions.forEach(
				entry -> {
					Assertions.assertEquals(entry.getExpected(), entry.getResultTree());
					Assertions.assertEquals(entry.getExpected(), entry.getResultQueue());
				}
		);

	}

	private int[] randomArray(int size, int maxValue, boolean withNegativeValues) {
		if(maxValue==0) maxValue=2;
		if(size==0) size=1;
		Random rand = new Random();
		int[] A = new int[size];

		if(!withNegativeValues) {
			for(int i=0; i<size; i++) {
				A[i] = rand.nextInt(maxValue);
			}
		}
		else {
			int negative;
			for(int i=0; i<size; i++) {
				negative = rand.nextInt(2);
				if (negative==0) {
					A[i] = rand.nextInt(maxValue);
				} else if (negative==1) {
					A[i] = - rand.nextInt(maxValue);
				}
			}
		}

		return A;
	}

	private Assertion execute(int K, int[] A, int ArrayID) {
		int solutionTree = countBoundedSlices.solutionWithTree(K, A);
		int solutionQueue = countBoundedSlices.solutionWithQueues(K, A);
		int check = check(K, A);

		if (solutionTree!=check) {
			System.out.println("FAILED " + ArrayID + "  ---- K: " + K + " - A len: " + A.length + " ----- check: "+ check + " - solTree: " + solutionTree+ " - solQueue: " + solutionQueue);
		} else {
			System.out.println("K: " + K + " - A(size, id): (" + A.length + ", " + ArrayID + ") ----- check: "+ check + " - solTree: " + solutionTree+ " - solQueue: " + solutionQueue);
		}
		return Assertion.builder().expected(check).resultTree(solutionTree).resultQueue(solutionQueue).build();
	}

	private int check(int K, int[] A) {
		int count = A.length;
		if(count>=1000000000) return 1000000000;

		int max;
		int min;
		for(int i=0;i<A.length;i++) {
				min=A[i];
				max=A[i];
				for(int j=i+1;j<A.length;j++) {
					min = Math.min(min, A[j]);
					max = Math.max(max, A[j]);

					if ((max - min) > K) {
						break;
					}

					count++;

					if (count >= 1000000000) return 1000000000;
				}

		}
		return count;
	}

	@Getter
	@Setter
	@Builder
	static class Assertion {
		int resultTree;
		int resultQueue;
		int expected;
	}

}
