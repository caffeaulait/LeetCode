package com.caffeaulait.problemset;

public class _0081_SearchInRotatedSortedArrayII {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     *
     * You are given a target value to search. If found in the array return true, otherwise return false.
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * Follow up:
     *
     * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     * Would this affect the run-time complexity? How and why?
     */

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        while (left <= right){
            mid = (left + right)>>1;
            if (nums[mid]==target)
                return true;
            if (nums[left]==nums[mid]&&nums[mid]==nums[right]){
                left++;
                right--;
            }
            else if (nums[left]<=nums[mid]){
                if (target>=nums[left] && target<nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else{
                if (target>nums[mid] && target<=nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
