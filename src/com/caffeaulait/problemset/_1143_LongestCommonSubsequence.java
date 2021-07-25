package com.caffeaulait.problemset;

public class _1143_LongestCommonSubsequence {
    /**
     * Given two strings text1 and text2, return the length of their longest common subsequence.
     *
     * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
     *
     *
     *
     * If there is no common subsequence, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3
     * Explanation: The longest common subsequence is "ace" and its length is 3.
     * Example 2:
     *
     * Input: text1 = "abc", text2 = "abc"
     * Output: 3
     * Explanation: The longest common subsequence is "abc" and its length is 3.
     * Example 3:
     *
     * Input: text1 = "abc", text2 = "def"
     * Output: 0
     * Explanation: There is no such common subsequence, so the result is 0.
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) dp[i][0] = 0;
        for (int j = 0; j <= len2; j++) dp[0][j] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
