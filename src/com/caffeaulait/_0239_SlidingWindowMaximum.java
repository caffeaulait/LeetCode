package com.caffeaulait;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0239_SlidingWindowMaximum {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     *
     * Example:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     *
     * Follow up:
     * Could you solve it in linear time?
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<k || k<1) return new int[0];
        int[] result = new int[nums.length-k+1];
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i <k; i++) heap.add(nums[i]);
        result[0] = heap.peek();
        int index = 1;
        for (int i = 0, j = k; j<nums.length;i++,j++,index++){
            heap.remove(nums[i]);
            heap.add(nums[j]);
            result[index] = heap.peek();
        }
        return result;
    }
}
