package com.caffeaulait.problemset;

public class _0300_LongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * Example:
     *
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Note:
     *
     * There may be more than one LIS combination, it is only necessary for you to return the length.
     * Your algorithm should run in O(n2) complexity.
     * Follow up: Could you improve it to O(n log n) time complexity?
     */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        int [] dp = new int[n];
        int result = 1;
        for (int i = 0;i<n;i++){
            dp[i] = 1;
            for (int j =0;j<i;j++){
                if (nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            result = Math.max(result,dp[i]);
        }
        return result;

    }

}
