package com.caffeaulait.problemset;

public class _0661_ImageSmoother {
    /**
     * An image smoother is a filter of the size 3 x 3 that can be applied to
     * each cell of an image by rounding down the average of the cell and the
     * eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
     * If one or more of the surrounding cells of a cell is not present,
     * we do not consider it in the average (i.e., the average of the four cells in the red smoother).
     *
     * Example 1:
     * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[0,0,0],[0,0,0],[0,0,0]]
     * Explanation:
     * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
     * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
     * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
     */

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][]result = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = calc(img, i, j);
            }
        }
        return result;
    }

    public int calc(int[][] img, int i, int j) {
        int m = img.length;
        int n = img[0].length;
        int sum = img[i][j];
        int count = 1;
        if(i >= 1) {
            sum += img[i-1][j];
            count++;
        }
        if(i >= 1 && j >= 1) {
            sum += img[i-1][j-1];
            count++;
        }
        if(i >= 1 && j < n - 1) {
            sum += img[i-1][j+1];
            count++;
        }
        if(j >= 1) {
            sum+= img[i][j-1];
            count++;
        }
        if(j < n - 1) {
            sum += img[i][j+1];
            count++;
        }
        if(i < m - 1) {
            sum += img[i+1][j];
            count++;
        }
        if(i < m - 1 && j >= 1) {
            sum += img[i+1][j-1];
            count++;
        }
        if(i < m - 1 && j < n - 1) {
            sum += img[i+1][j+1];
            count++;
        }
        return (int) Math.floor(sum / (count * 1.0));
    }

}
