package com.caffeaulait.contest.weekly;


public class WeeklyContest299 {
    /**
     * q1
     * q2
     */

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j || i+j==n-1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        double o = placeOneSide(n);
        double v = o % 1000000007;
        return (int) (v * v % 1000000007);
    }

    public double placeOneSide(int n) {
        double[] dp = new double[n+1];
        if (n == 1) return 2;
        if (n == 2) return 3;
        dp[1] = 2;
        dp[2] = 3;
        //max num of houses can be placed in n spots;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WeeklyContest299 w = new WeeklyContest299();
        System.out.println(w.countHousePlacements(1000));
    }

}