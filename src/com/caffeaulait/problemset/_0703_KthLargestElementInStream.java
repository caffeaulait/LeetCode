package com.caffeaulait.problemset;

import java.util.PriorityQueue;

public class _0703_KthLargestElementInStream {
    /**
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
     *
     * Example:
     *
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     */
    class KthLargest {
        int k;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            }else if (pq.peek() < val){
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
