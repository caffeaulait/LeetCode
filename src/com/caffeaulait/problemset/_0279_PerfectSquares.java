package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0279_PerfectSquares {
    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
     *
     * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     */

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (j*j <= i){
                min = Math.min(min, dp[i- j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
