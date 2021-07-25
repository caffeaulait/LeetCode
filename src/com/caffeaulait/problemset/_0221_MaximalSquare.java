package com.caffeaulait.problemset;

public class _0221_MaximalSquare {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Output: 4
     */

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i<= m; i++){
            for (int j = 1; j <= n; j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}
