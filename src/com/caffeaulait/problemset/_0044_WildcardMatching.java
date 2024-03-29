package com.caffeaulait.problemset;

public class _0044_WildcardMatching {
    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
     *
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     * Example 3:
     *
     * Input:
     * s = "cb"
     * p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     * Example 4:
     *
     * Input:
     * s = "adceb"
     * p = "*a*b"
     * Output: true
     * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
     * Example 5:
     *
     * Input:
     * s = "acdcb"
     * p = "a*c?b"
     * Output: false
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length(), pLen= p.length();
        //dp[i][j]: true if the first i char in String s matches the first j chars in String p
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for (int i = 1; i <= sLen ;i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= pLen; j++){
            if (p.charAt(j-1) == '*')  dp[0][j] = true;
            else break;
        }
        for (int i = 1; i <=sLen; i++) {
            for (int j = 1; j<=pLen; j++){
                if (p.charAt(j-1)!='*') {
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1)=='?' || s.charAt(i-1) == p.charAt(j-1));
                }else {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
