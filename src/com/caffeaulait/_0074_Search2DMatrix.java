package com.caffeaulait;

public class _0074_Search2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length-1;
        for (int i = 0; i < matrix.length-1;i++){
            if (target == matrix[i][0] || target == matrix[i+1][0]) return true;
            if (target > matrix[i][0] && target < matrix[i+1][0]) {
                row = i;
                break;
            }
        }
        int lo = 0, hi = matrix[row].length-1;
        while (lo <= hi){
            int mid = (lo + hi)/2;
            if (target == matrix[row][mid]) return true;
            else if (target > matrix[row][mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
