package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0041_FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     */

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (nums[i] > 0 && nums[i] <= n && nums[i]!=i+1 ){
                swap(nums, i,  nums[i]-1);
            }
        }

        for (int i = 0; i<n; i++){
            if (nums[i]!=i+1) return i+1;
        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
