package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0054_SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     *
     * Example 1:
     *
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     *
     * Input:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int rowt = 0, rowb = matrix.length-1;
        int coll= 0, colr = matrix[0].length-1;
        while (res.size() < m * n) {
            for (int i = coll; i<= colr && res.size() < n * m; i++) {
                res.add(matrix[rowt][i]);
            }
            for (int j = rowt+1;j<=rowb && res.size() < n * m;j++){
                res.add(matrix[j][colr]);
            }
            for (int i = colr-1; i>=coll && res.size() < n * m;i--){
                res.add(matrix[rowb][i]);
            }
            for (int j = rowb-1;j>=rowt+1 && res.size() < n * m;j--){
                res.add(matrix[j][coll]);
            }
            rowt++;
            rowb--;
            coll++;
            colr--;
        }
        return res;
    }
}
