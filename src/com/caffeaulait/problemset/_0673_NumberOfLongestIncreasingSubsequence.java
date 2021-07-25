package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0673_NumberOfLongestIncreasingSubsequence {
    /**
     * Given an integer array nums, return the number of longest increasing subsequences.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,4,7]
     * Output: 2
     * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2]
     * Output: 5
     * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] len = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        for (int j = 0; j < n; j++){
            for (int i = 0; i < j; i++){
                if (nums[i] < nums[j]) {
                    if (len[i] >= len[j]) {
                        len[j] = len[i] + 1;
                        cnt[j] = cnt[i];
                    }else if (len[i] + 1 == len[j]){
                        cnt[j] += cnt[i];
                    }
                }
            }
        }
        int max = 0, res = 0;
        for (int l : len) {
            max = Math.max(max, l);
        }
        for (int i = 0; i < cnt.length; i++){
            if (len[i] == max) res+=cnt[i];
        }
        return res;
    }
}
