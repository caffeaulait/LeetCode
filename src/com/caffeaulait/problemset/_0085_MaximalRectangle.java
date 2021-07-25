package com.caffeaulait.problemset;

public class _0085_MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length;j++){
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int[] lowerLeft = new int[heights.length];
        int[] lowerRight = new int[heights.length];
        lowerRight[heights.length-1] = heights.length;
        lowerLeft[0] = -1;

        for (int i = 1; i < heights.length; i++){
            int curr = i - 1;
            while (curr >=0 && heights[curr] >= heights[i]) curr = lowerLeft[curr];
            lowerLeft[i] = curr;
        }
        for (int j = heights.length-2; j >=0; j--){
            int curr = j+1;
            while (curr < heights.length && heights[curr]>= heights[j]) curr = lowerRight[curr];
            lowerRight[j] = curr;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            maxArea = Math.max(maxArea, (lowerRight[i] - lowerLeft[i] -1) * heights[i]);
        }
        return maxArea;
    }
}
