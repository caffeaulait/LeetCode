package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0016_3SumClosest {
    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *
     * Example:
     *
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for (int i = 0; i < nums.length-2; i++){
            int j = i + 1, k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target){
                    k--;
                }else{
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }
}
