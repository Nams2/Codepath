package com.namrata;

import java.util.PriorityQueue;

/**
 * 
 *
 *
 *
 Kth Smallest Element in the ArrayBookmark Suggest Edit

 Find the kth smallest element in an unsorted array of non-negative integers.

 Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
 NOTE
 You are not allowed to modify the array ( The array is read only ).
 Try to do it using constant extra space.

 Example:

 A : [2 1 4 3 2]
 k : 3

 answer : 2
 *
 */

public class KthSmallestInArray {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=0;i<A.length;i++) {
            q.offer(A[i]);
        }
        int n = -1;
        while( B>0) {
            n = q.poll();
            B--;
        }
        return n;
    }

}
