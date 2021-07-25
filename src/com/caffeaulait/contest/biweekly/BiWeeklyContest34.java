package com.caffeaulait.contest.biweekly;


public class BiWeeklyContest34 {

    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */

    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += mat[i][i];
        }
        for (int i = row - 1; i >= 0; i--){
            sum += mat[row-i-1][i];
        }
        if (row % 2 == 1){
            sum -= mat[row/2][row/2];
        }
        return sum;
    }

    public int numWays(String s) {
        return 0;
    }

}
