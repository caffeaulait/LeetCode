package com.caffeaulait.problemset;

public class _0153_FindMinimumInRotatedSortedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     *
     * Find the minimum element.
     *
     * You may assume no duplicate exists in the array.
     *
     * Example 1:
     *
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     *
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     */

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) break;
            int mid = (lo+hi)/2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            }else {
                lo = mid+1;
            }
        }
        return nums[lo];
    }
}
