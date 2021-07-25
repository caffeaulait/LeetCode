package com.caffeaulait.problemset;

public class _0132_PalindromePartitioningII {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output: 1
     * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */

    public int minCut(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        int[] res = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = 0; j <= i; j++){
                if (chs[j] == chs[i] && (j + 1 > i - 1 || pal[j+1][i-1] )) {
                    pal[j][i] = true;
                    if (j == 0) min = 0;
                    else min = Math.min(min, res[j-1]+1);
                }
            }
            res[i] = min;
        }
        return res[n-1];
    }
}
