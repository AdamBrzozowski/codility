package com.projects.codility.medium;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.LinkedList;

@Service
public class CountBoundedSlices {
    int MAX_COUNT = 1000000000;

    public int solutionWithQueues(int K, int[] A) {
        int N = A.length;
        int count = 0;
        int P = 0;

        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        for (int Q = 0; Q < N; Q++) {
            // If LAST (chronologically) inserted possible MAX is <= A[Q] it will never be MAX (because it s before current position Q) so we can remove it
            while (!maxQueue.isEmpty() && A[maxQueue.peekLast()] <= A[Q]) {
                maxQueue.pollLast();
            }
            // Save position of last possible Max -> if maxQueue is empty it s the current Max
            maxQueue.offerLast(Q);

            // Same as maxQueue
            while (!minQueue.isEmpty() && A[minQueue.peekLast()] >= A[Q]) {
                minQueue.pollLast();
            }
            // Same as maxQueue
            minQueue.offerLast(Q);

            // Check and maintain the condition of the bounded slice
            while (A[maxQueue.peekFirst()] - A[minQueue.peekFirst()] > K) {
                P++;
                // If position of current MAX is < P it means it s outside the range we are considering
                // position of MAX -> becomes next value in the queue
                if (maxQueue.peekFirst() < P) {
                    maxQueue.pollFirst();
                }
                if (minQueue.peekFirst() < P) {
                    minQueue.pollFirst();
                }
            }

            // The number of bounded slices ending at Q with starting index from P to Q
            count += Q - P + 1;

            // Return 1,000,000,000 if the count exceeds this limit
            if (count > MAX_COUNT) {
                return MAX_COUNT;
            }
        }

        return count;
    }

    public int solutionWithTree(int K, int[] A) {
        int N = A.length;
        int count = N;
        if(count>=MAX_COUNT) return MAX_COUNT;

        SegmentTree segmentTree = null;

        int max=0;
        int min=0;
        int lastj = 0;
        for(int i=0;i<N-1;i++) {
            // There are no MAX and MIN values from the current point to the end of the array such that MAX-MIN > K.
            if(lastj==(N-1)) {
                count += N - (i+1);
                if(count>=MAX_COUNT) return MAX_COUNT;
            }
            // The sliding range has only 1 element, so that element is both the MAX and the MIN.
            else if(lastj==i) {
                min=A[i];
                max=A[i];
                for(int j=i+1;j<N;j++) {
                    min=Math.min(min,A[j]);
                    max=Math.max(max,A[j]);

                    if((max-min)>K) {
                        // Save last position for which the condition (max-min)>K is true
                        // The condition (max-min)>K is true for ALL arrays subsets -> (i,lastj) (i+1,lastj) .... (lastj,lastj)
                        // so in  - else if (i<lastj) - we can start cicle at lastj+1
                        lastj=j-1;
                        // So at next iteration it will go in if(lastj==i) again
                        if(j==i+1) lastj=j;
                        break;
                    }

                    // The condition (max-min)>K is true for ALL remaining arrays subsets  -> no need to calculate MAX MIN again
                    if(j==(N-1)) lastj=j;

                    count++;

                    if(count>=MAX_COUNT) return MAX_COUNT;
                }
            } else if (i<lastj) {
                count += lastj - (i);
                if(count>=MAX_COUNT) return MAX_COUNT;
                if(A[i-1]==min || A[i-1]==max) {
                    // With the tree we can find max min in O(logN) time
                    if(segmentTree==null) segmentTree = new SegmentTree(A);
                    min = segmentTree.query(i, lastj).getMin();
                    max = segmentTree.query(i, lastj).getMax();
                }
                for(int j=lastj+1;j<N;j++) {
                    min=Math.min(min,A[j]);
                    max=Math.max(max,A[j]);

                    if((max-min)>K) {
                        lastj=j-1;
                        if(j==i+1) lastj=j; // to comment?
                        break;
                    }

                    if(j==(N-1)) lastj=j;
                    count++;

                    if(count>=MAX_COUNT) return MAX_COUNT;
                }
                if(count>=MAX_COUNT) return MAX_COUNT;
            } else {
                count += N - (i+1);
                if(count>=MAX_COUNT) return MAX_COUNT;
            }
        }

        return count;
    }

    public class SegmentTree {
        private int[] treeMin;
        private int[] treeMax;
        private int n;

//		private Node[] Nodes;

//		@Getter
//		@Setter
//		@Builder
//		static class Node {
//			int min;
//			int start;
//			int end;
//		}

        @Getter
        @Setter
        @Builder
        static class MINMAX {
            int min;
            int max;
        }

        // Constructor to initialize the Segment Tree
        public SegmentTree(int[] arr) {
            n = arr.length;
            treeMin = new int[4 * n]; // Allocate memory for segment tree
            treeMax = new int[4 * n];
//			Nodes = new Node[4 * n];
            buildSegmentTree(arr, 0, 0, n - 1);
        }

        // Function to build the Segment Tree
        private void buildSegmentTree(int[] arr, int node, int start, int end) {
            if (start == end) {
                // Leaf node: store the array value
                treeMin[node] = arr[start];
                treeMax[node] = arr[start];
//				Node build = Node.builder().min(arr[start]).start(start).end(end).build();
//				Nodes[node] = build;
            } else {
                int mid = start + (end - start) / 2;

                // Save LEFT child in position:
                // 2 * node + 1
                // and RIGHT in:
                // 2 * node + 2
                // Recursively build left and right subtrees
                buildSegmentTree(arr, 2 * node + 1, start, mid);
                buildSegmentTree(arr, 2 * node + 2, mid + 1, end);
                // Internal node: store the minimum of left and right children
                treeMin[node] = Math.min(treeMin[2 * node + 1], treeMin[2 * node + 2]);
                treeMax[node] = Math.max(treeMax[2 * node + 1], treeMax[2 * node + 2]);

//				Node build = NODO.builder().min(tree[node]).start(start).end(end).build();
//				Nodes[node] = build;
            }
        }

        // Function to query the minimum and maximum in a given range
        public MINMAX query(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }

        // Helper function for range query
        // "node" = position at which MIN/MAX is stored for ARRAY range from "start" to "end"
        private MINMAX query(int node, int start, int end, int left, int right) {
            // If the range is completely outside
            if (right < start || left > end) {
                return MINMAX.builder().min(Integer.MAX_VALUE).max(Integer.MIN_VALUE).build();
                // Return MAX value in "min" to ignore this range
                // Return MIN value in "max" to ignore this range
            }

            // If the range is completely inside
            if (left <= start && end <= right) {
                // Return min max of entire Subtree
                return MINMAX.builder().min(treeMin[node]).max(treeMax[node]).build();
            }

            // If the range is partially inside and outside
            int mid = start + (end - start) / 2;

            // Left child is stored at position:
            // 2 * node + 1
            MINMAX leftMinMax = query(2 * node + 1, start, mid, left, right);
            // Right child is stored at position:
            // 2 * node + 2
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
