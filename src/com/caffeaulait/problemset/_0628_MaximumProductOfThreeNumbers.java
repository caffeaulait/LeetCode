package com.caffeaulait.problemset;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0628_MaximumProductOfThreeNumbers {
    /**
     * Given an integer array, find three numbers whose product is maximum and output the maximum product.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: 6
     *
     *
     * Example 2:
     *
     * Input: [1,2,3,4]
     * Output: 24
     *
     */

    public int maximumProduct(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> nq = new PriorityQueue<>((a,b) -> (b-a));
        for (int num : nums){
            pq.offer(num);
            nq.offer(num);
            if (pq.size() > 3) pq.poll();
            if (nq.size() > 2) nq.poll();
        }
        int pos = 1;
        int max = 0;
        while (!pq.isEmpty()){
            max = pq.poll();
            pos *= max;
        }
        int neg = max;
        int min = 0;
        while (!nq.isEmpty()){
            min = nq.poll();
            neg *= min;
        }
        return Math.max(pos, neg);
    }
}
