package com.caffeaulait.problemset;

import java.util.*;

public class _0264_UglyNumber {
    /**
     * Write a program to find the n-th ugly number.
     *
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     *
     * Example:
     *
     * Input: n = 10
     * Output: 12
     * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     * Note:
     *
     * 1 is typically treated as an ugly number.
     * n does not exceed 1690.
     */
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int ugly = Math.min(p2Val, Math.min(p3Val, p5Val));
            if (p2Val == ugly) p2++;
            if (p3Val == ugly) p3++;
            if (p5Val == ugly) p5++;
            dp[i] = ugly;
        }
        return dp[n-1];
    }
}
