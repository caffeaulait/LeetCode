package com.caffeaulait.problemset;

public class _0033_SearchInRotatedSortedArray {
    /**
     * #33
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;

            //the first half is incremental
            if (nums[lo] <= nums[mid]){
                if (target >= nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
                //the second half is incremental
            }else{
                if (target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
