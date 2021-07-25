package com.caffeaulait.problemset;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0215_KthLargestElementInAnArray {
    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public int findKthLargest(int[] nums, int k) {
        int result = 0;

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i : nums){
            queue.add(i);
        }

        while (k>0){
            result = queue.poll();
            k--;
        }
        return result;
    }
}
