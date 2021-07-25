package com.caffeaulait.problemset;

public class _0115_DistinctSubsequence {
    /**
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
     *
     * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     *
     * It's guaranteed the answer fits on a 32-bit signed integer.
     *
     * Example 1:
     *
     * Input: S = "rabbbit", T = "rabbit"
     * Output: 3
     * Explanation:
     * As shown below, there are 3 ways you can generate "rabbit" from S.
     * (The caret symbol ^ means the chosen letters)
     *
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     * Example 2:
     *
     * Input: S = "babgbag", T = "bag"
     * Output: 5
     * Explanation:
     * As shown below, there are 5 ways you can generate "bag" from S.
     * (The caret symbol ^ means the chosen letters)
     *
     * babgbag
     * ^^ ^
     * babgbag
     * ^^    ^
     * babgbag
     * ^    ^^
     * babgbag
     *   ^  ^^
     * babgbag
     *     ^^^
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) != t.charAt(j-1)) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
