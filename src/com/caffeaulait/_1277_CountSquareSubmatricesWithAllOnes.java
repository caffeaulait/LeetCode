package com.caffeaulait;

public class _1277_CountSquareSubmatricesWithAllOnes {
    /**
     * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     *
     *
     * Example 1:
     *
     * Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     * Example 2:
     *
     * Input: matrix =
     * [
     *   [1,0,1],
     *   [1,1,0],
     *   [1,1,0]
     * ]
     * Output: 7
     * Explanation:
     * There are 6 squares of side 1.
     * There is 1 square of side 2.
     * Total number of squares = 6 + 1 = 7.
     */

    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = matrix[i][j];
                if (matrix[i][j] >0 && i>0 && j >0){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
