package com.caffeaulait;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * If the target is not found in the array, return [-1, -1].
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int lo = 0, hi = nums.length-1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else if (nums[mid] > target)
                hi = mid - 1;
            else {
                return expandAroundCenter(nums,mid);
            }
        }
        return result;
    }


    public int[] expandAroundCenter(int[] nums, int index){
        int start = index-1, end = index+1;
        int target = nums[index];
        int leftCount = 0, rightCount = 0;
        while (start >= 0 && nums[start] == target){
            start--;
            leftCount++;
        }

        while (end < nums.length && nums[end] == target){
            end++;
            rightCount++;
        }

        int result[] = {index-leftCount, index+rightCount};

        return result;
    }

}
