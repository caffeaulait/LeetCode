package com.caffeaulait;

public class _0200_NumberOfIslands {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     */

    public int numIslands(char[][] grid) {
        if (grid.length==0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        int rows = grid.length, cols = grid[0].length;
        if (r< 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') return;
        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }
}
