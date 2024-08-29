package com.projects.codility.medium;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class CountBoundedSlices {
    public int solution(int K, int[] A) {
        // Implement your solution here
        int count = A.length;
        if(count>=1000000000) return 1000000000;


        SegmentTree segmentTree = new SegmentTree(A);


        int max=0;
        int min=0;
        int lastj = 0;
        for(int i=0;i<A.length-1;i++) {
            // System.out.println("NEXT---"+"i:" + i + " - lastj:" + lastj + " - count:" + count );
            if(lastj==(A.length-1)) {
                count += A.length - (i+1);
            }
            else if(lastj==i) {
                // System.out.println("==");
                min=A[i];
                max=A[i];
                for(int j=i+1;j<A.length;j++) {
                    min=Math.min(min,A[j]);
                    max=Math.max(max,A[j]);

                    // System.out.println("i j:" + i + "-"+j);
                    if((max-min)>K) {
                        lastj=j-1;
                        if(j==i+1) lastj=j;
                        break;
                    }

                    if(j==(A.length-1)) lastj=j;

                    count++;

                    if(count>=1000000000) return 1000000000;
                }
            } else if (i<lastj) {
                count += lastj - (i);
                min=segmentTree.query(i,lastj).getMin();
                max=segmentTree.query(i,lastj).getMax();
                for(int j=lastj+1;j<A.length;j++) {
                    min=Math.min(min,A[j]);
                    max=Math.max(max,A[j]);

                    // System.out.println("i j:" + i + "-"+j);
                    if((max-min)>K) {
                        lastj=j-1;
                        // if(j==i+1) lastj=j;
                        break;
                    }

                    if(j==(A.length-1)) lastj=j;
                    count++;

                    if(count>=1000000000) return 1000000000;
                }
                // System.out.println("< -- count:" + count);
                if(count>=1000000000) return 1000000000;
            } else {
                // System.out.println(">>> -- count:" + count + " - sum:"+ (A.length - (i+1)));
                count += A.length - (i+1);
                if(count>=1000000000) return 1000000000;
                // System.out.println(">>> -- count:" + count);
            }
        }

        // System.out.println("FINAL -- count:" + count);
        return count;
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
