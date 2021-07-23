package com.caffeaulait;

public class _0329_LongestIncreasingPathInMatrix {

    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] cached = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, cached));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] cached) {
        if (cached[i][j] != 0) {
            return cached[i][j];
        }
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, cached);
            max = Math.max(max, len);
        }
        cached[i][j] = max;
        return max;
    }
}
