package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0198_HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it
     * will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
     * you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     *
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     *              Total amount you can rob = 2 + 9 + 1 = 12.
     */


    //1. Recursive Top-Down
//    public int rob(int[] nums) {
//        return rob(nums,nums.length-1);
//    }
//
//    private int rob(int[] nums, int i){
//        if (i<0) return 0;
//        return Math.max(rob(nums,i-2)+nums[i], rob(nums,i-1));
//    }

    //2. Recursive + Memo Top-Down
//    int [] memo;
//    public int rob(int[] nums){
//        memo = new int[nums.length];
//        Arrays.fill(memo,-1);
//        return rob(nums,nums.length-1);
//    }
//
//    private int rob(int[] nums, int i){
//        if (i<0) return 0;
//        if (memo[i]>=0) return memo[i];
//        int result = Math.max(rob(nums,i-2)+nums[i], rob(nums,i-1));
//        memo[i] = result;
//        return result;
//    }

    //3. Iterative + Memo Bottom-up
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i<nums.length;i++){
            memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
        }
        return memo[nums.length-1];
    }
}
