package com.caffeaulait;

public class _0059_SpiralMatrixII {
    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     *
     * Example:
     *
     * Input: 3
     * Output:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     */
    public int[][] generateMatrix(int n) {
        int curr = 1;
        int count = n * n;
        int rowt = 0, rowb = n - 1;
        int coll = 0, colr = n - 1;
        int[][] result = new int[n][n];
        while (curr <= count){
            for (int i = coll; i<= colr && curr<=count; i++) {
                result[rowt][i] = curr++;
            }
            for (int j = rowt + 1; j<=rowb && curr <= count; j++){
                result[j][colr] = curr++;
            }
            for (int i = colr-1; i>= coll && curr<=count; i--){
                result[rowb][i] = curr++;
            }
            for (int j = rowb-1; j>= rowt+1 && curr <= count; j--){
                result[j][coll] = curr++;
            }
            rowt++;
            rowb--;
            coll++;
            colr--;
        }
        return result;
    }
}
