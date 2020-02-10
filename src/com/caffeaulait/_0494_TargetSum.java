package com.caffeaulait;

import java.util.Arrays;
import java.util.List;

public class _0494_TargetSum {
    /**
     *
     You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:
     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:

     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3

     There are 5 ways to assign symbols to make the sum of nums be target 3.
     Note:
     The length of the given array is positive and will not exceed 20.
     The sum of elements in the given array will not exceed 1000.
     Your output answer is guaranteed to be fitted in a 32-bit integer.
     */

    //                  sum(P) - sum(N) = target
    //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                       2 * sum(P) = target + sum(nums)

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int el : nums) sum += el;
        if (sum < S || (sum + S)%2>0)
            return 0;
        else
            return subsetSum(nums, (sum+S)/2);
    }

    private int subsetSum(int[] nums, int target){
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++){
            for (int j = 0; j <= target; j++){
                if (j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

}
