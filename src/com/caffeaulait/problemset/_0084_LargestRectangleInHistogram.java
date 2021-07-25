package com.caffeaulait.problemset;

public class _0084_LargestRectangleInHistogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     *
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     *

     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * Example:
     *
     * Input: [2,1,5,6,2,3]
     * Output: 10
     */

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int[] lowerLeft = new int[heights.length];
        int[] lowerRight = new int[heights.length];
        lowerRight[heights.length-1] = heights.length;
        lowerLeft[0] = -1;

        for (int i = 1; i < heights.length; i++){
            int curr = i - 1;
            while (curr >=0 && heights[curr] >= heights[i]) curr--;
            lowerLeft[i] = curr;
        }
        for (int j = heights.length-2; j >=0; j--){
            int curr = j+1;
            while (curr < heights.length && heights[curr]>= heights[j]) curr++;
            lowerRight[j] = curr;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            maxArea = Math.max(maxArea, (lowerRight[i] - lowerLeft[i] -1) * heights[i]);
        }
        return maxArea;
    }
}
