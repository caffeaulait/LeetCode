package com.caffeaulait.problemset;

public class _0154_FindMinimumInRotatedSortedArrayII {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     *
     * Find the minimum element.
     *
     * The array may contain duplicates.
     *
     * Example 1:
     *
     * Input: [1,3,5]
     * Output: 1
     * Example 2:
     *
     * Input: [2,2,2,0,1]
     * Output: 0
     * Note:
     */
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[hi]){
                hi = mid;
            }else if (nums[mid] > nums[hi]){
                lo = mid + 1;
            }else {
                hi = hi - 1;
            }
        }
        return nums[lo];
    }
}
