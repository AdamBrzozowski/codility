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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootTest
class CountBoundedSlicesTests {

	@Autowired
	private CountBoundedSlices countBoundedSlices;

	@Test
	void countBoundedSlicesTest() {
		ArrayList<Assertion> assertions = new ArrayList<>();

		Random rand = new Random();

//		SegmentTree segmentTree = new SegmentTree(new int[]{2, 3, 4, 1, 2, 3, 7, 1, 4, 3, 8, 2, 1, 0, 3, 8, 6, 7, 5, 4, 7, 2, 4, 3, 8, 4, 3, 5, 0, 1, 6, 8, 1, 0, 9});
//		SegmentTree.MINMAX query = segmentTree.query(0, 2);
//
//		System.out.println("min: "+query.getMin() + " - max: " + query.getMax());
//		 query = segmentTree.query(4, 12);
//
//		System.out.println("min: "+query.getMin() + " - max: " + query.getMax());
//		 query = segmentTree.query(8, 9);
//
//		System.out.println("min: "+query);
//
//		query = segmentTree.query(7, 9);
//
//		System.out.println("min: "+query);
//		query = segmentTree.query(13, 18);
//
//		System.out.println("min: "+query);
//		assertions.add(execute(2,new int[]{2, 3, 4, 1, 2, 3, 7, 1, 4, 3, 8, 2, 1, 0, 3, 8, 6, 7, 5, 4, 7, 2, 4, 3, 8, 4, 3, 5, 0, 1, 6, 8, 1, 0, 9}));


//		assertions.add(execute(2,new int[]{1,2,3}));
		assertions.add(execute(2,new int[]{100,100,100,100,100}));
//		assertions.add(execute(2,new int[]{2, 3, 4, 1, 2, 3, 7, 1, 4, 3, 8, 2, 1, 0, 3, 8, 6, 7, 5, 4, 7, 2, 4, 3, 8, 4, 3, 5, 0, 1, 6, 8, 1, 0, 9}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));
//		assertions.add(execute(2,new int[]{rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)}));

//				assertions.add(execute(2,new int[]{20,21}));
//		assertions.add(execute(2,new int[]{20,222}));
//		assertions.add(execute(2,new int[]{-12,-10,20,4,34,33,1,1,64,2255254,2,-42342342}));
//		assertions.add(execute(999999999,new int[]{-12,-10,20,4,34,33,1,1,64,2255254,2,-42342342}));

		assertions.forEach(
				entry -> Assertions.assertEquals(entry.getExpected(), entry.getResult())
		);

	}

	private Assertion execute(int K, int[] A) {
		int solution = countBoundedSlices.solution(K, A);
		int check = check(K, A);

		System.out.println("K: " + K + " - A: " + Arrays.toString(A) + " ----- check: "+ check + " - sol: " + solution);
		return Assertion.builder().expected(check).result(solution).build();
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
		int result;
		int expected;
	}

	public class SegmentTree {
		private int[] treeMin;   // Segment tree array
		private int[] treeMax;
		private int n;

//		private NODO[] NODI;
//		private ArrayList<Integer> arrayList;

//		@Getter
//		@Setter
//		@Builder
//		static class NODO {
//			int min;
//			int start;
//			int end;
//		}// Size of the input array

		@Getter
		@Setter
		@Builder
		static class MINMAX {
			int min;
			int max;
		}// Size of the input array


		// Constructor to initialize the Segment Tree
		public SegmentTree(int[] arr) {
			n = arr.length;
			treeMin = new int[4 * n]; // Allocate memory for segment tree
			treeMax = new int[4 * n];
//			NODI = new NODO[4 * n];
//			arrayList = new ArrayList<>();
			buildSegmentTree(arr, 0, 0, n - 1);
		}

		// Function to build the Segment Tree
		private void buildSegmentTree(int[] arr, int node, int start, int end) {
			if (start == end) {
				// Leaf node: store the array value
//				arrayList.add(1);
				treeMin[node] = arr[start];
				treeMax[node] = arr[start];


//				NODO build = NODO.builder().min(arr[start]).start(start).end(end).build();
//				NODI[node]  = build;
			} else {
				int mid = start + (end - start) / 2;
				// Recursively build left and right subtrees
				buildSegmentTree(arr, 2 * node + 1, start, mid);
				buildSegmentTree(arr, 2 * node + 2, mid + 1, end);
				// Internal node: store the minimum of left and right children
//				arrayList.add(1);
				treeMin[node] = Math.min(treeMin[2 * node + 1], treeMin[2 * node + 2]);
				treeMax[node] = Math.max(treeMax[2 * node + 1], treeMax[2 * node + 2]);

//				NODO build = NODO.builder().min(tree[node]).start(start).end(end).build();
//				NODI[node]  = build;
			}
		}

		// Function to query the minimum in a given range
		public MINMAX query(int left, int right) {
			return query(0, 0, n - 1, left, right);
		}

		// Helper function for range query
		private MINMAX query(int node, int start, int end, int left, int right) {
			// If the range is completely outside
			if (right < start || left > end) {
				return MINMAX.builder().min(Integer.MAX_VALUE).max(Integer.MIN_VALUE).build();
//				return Integer.MAX_VALUE; // Return maximum value to ignore this range
			}

			// If the range is completely inside
			if (left <= start && end <= right) {
				return MINMAX.builder().min(treeMin[node]).max(treeMax[node]).build();
//				if(isMin) return treeMin[node];
//				return treeMax[node];
			}

			// If the range is partially inside and outside
			int mid = start + (end - start) / 2;
			MINMAX leftMinMax = query(2 * node + 1, start, mid, left, right);
			MINMAX rightMinMax = query(2 * node + 2, mid + 1, end, left, right);
			return MINMAX.builder().min(Math.min(leftMinMax.getMin(), rightMinMax.getMin()))
					.max(Math.max(leftMinMax.getMax(), rightMinMax.getMax())).build();
		}

		// Function to update an element in the array
//		public void update(int index, int value) {
//			update(0, 0, n - 1, index, value);
//		}

		// Helper function for point update
//		private void update(int node, int start, int end, int index, int value) {
//			if (start == end) {
//				// Leaf node: update the value
//				tree[node] = value;
//			} else {
//				int mid = start + (end - start) / 2;
//				if (index <= mid) {
//					update(2 * node + 1, start, mid, index, value);
//				} else {
//					update(2 * node + 2, mid + 1, end, index, value);
//				}
//				// Update the current node to the minimum of its children
//				tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
//			}
//		}
	}

}
