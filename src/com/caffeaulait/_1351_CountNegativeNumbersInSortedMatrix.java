package com.caffeaulait;

public class _1351_CountNegativeNumbersInSortedMatrix {
    /**
     * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
     *
     * Return the number of negative numbers in grid.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
     * Output: 8
     * Explanation: There are 8 negatives number in the matrix.
     * Example 2:
     *
     * Input: grid = [[3,2],[1,0]]
     * Output: 0
     * Example 3:
     *
     * Input: grid = [[1,-1],[-1,-1]]
     * Output: 3
     * Example 4:
     *
     * Input: grid = [[-1]]
     * Output: 1
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * -100 <= grid[i][j] <= 100
     * Accepted
     */

        /*
    This solution uses the fact that the negative regions of the matrix will form a "staircase" shape, e.g.:

        ++++++
        ++++--
        ++++--
        +++---
        +-----
        +-----
        What this solution then does is to "trace" the outline of the staircase.
     */

    public int countNegatives(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int r = row-1, c = 0;
        int count = 0;
        while (r>=0 && c < col){
            if (grid[r][c]<0){
                r--;
                count+= col-c;
            }else{
                c++;
            }
        }
        return count;
    }

}
