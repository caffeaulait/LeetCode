package com.caffeaulait.problemset;

public class _2444_CountSubarraysWithFixedBounds {

    /**
     * You are given an integer array nums and two integers minK and maxK.
     *
     * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
     *
     * The minimum value in the subarray is equal to minK.
     * The maximum value in the subarray is equal to maxK.
     * Return the number of fixed-bound subarrays.
     *
     * A subarray is a contiguous part of an array.
     * @param nums
     * @param minK
     * @param maxK
     * @return
     */

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        long jbad = -1, jmin = -1, jmax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK ) {
                jbad = i;
            }
            if (nums[i] == minK) {
                jmin = i;
            }
            if (nums[i] == maxK) {
                jmax = i;
            }
            res += Math.max(0, Math.min(jmax, jmin) - jbad);
        }
        return res;
    }
}
