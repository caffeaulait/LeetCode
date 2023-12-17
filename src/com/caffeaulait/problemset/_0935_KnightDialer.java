package com.caffeaulait.problemset;

public class _0935_KnightDialer {
    /**
     * The chess knight has a unique movement, it may move two squares vertically
     * and one square horizontally, or two squares horizontally and one square vertically
     * (with both forming the shape of an L).
     * The possible movements of chess knight are shown in this diagram
     */

    public static final long div = (long) Math.pow(10, 9) + 7;

    private long[][][] map;

    public int knightDialer(int n) {
        long s = 0;
        map = new long[4][3][n+1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                s = (s + findPaths(i, j, n)) % div;
            }
        }
        return (int) s;
    }

    private long findPaths(int i, int j, int n) {
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
        if(n == 1) return 1;
        if(map[i][j][n] > 0) return map[i][j][n];
        map[i][j][n] =  findPaths(i - 1, j - 2, n - 1) % div +
                        findPaths(i - 2, j - 1, n - 1) % div +
                        findPaths(i - 2, j + 1, n - 1) % div +
                        findPaths(i - 1, j + 2, n - 1) % div +
                        findPaths(i + 1, j + 2, n - 1) % div +
                        findPaths(i + 2, j + 1, n - 1) % div +
                        findPaths(i + 2, j - 1, n - 1) % div +
                        findPaths(i + 1, j - 2, n - 1) % div;
        return map[i][j][n];
    }
}
