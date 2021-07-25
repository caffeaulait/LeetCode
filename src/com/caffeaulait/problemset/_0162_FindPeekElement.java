package com.caffeaulait.problemset;

public class _0162_FindPeekElement {
    /**
     * A peak element is an element that is greater than its neighbors.
     *
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     *
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     *
     * You may imagine that nums[-1] = nums[n] = -∞.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * Example 2:
     *
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     *              or index number 5 where the peak element is 6.
     */
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) lo = mid2;
            else hi = mid1;
        }
        return hi;
    }
}
