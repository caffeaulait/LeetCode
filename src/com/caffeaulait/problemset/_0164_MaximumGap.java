package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0164_MaximumGap {
    /**
     *
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
     *
     * Return 0 if the array contains less than 2 elements.
     *
     * Example 1:
     *
     * Input: [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either
     *              (3,6) or (6,9) has the maximum difference 3.
     * Example 2:
     *
     * Input: [10]
     * Output: 0
     * Explanation: The array contains less than 2 elements, therefore return 0
     */

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i-1];
            max = Math.max(max, gap);
        }
        return max;
    }
}
