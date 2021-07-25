package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0120_Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     *
     * Note:
     *
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] sum = new int[n][n];
        for (int i =0; i < n; i ++) {
            sum[n-1][i] = triangle.get(n-1).get(i);
        }
        for (int layer = n - 2; layer >=0; layer--){
            for (int i = 0; i <=layer; i++){
                sum[layer][i] = Math.min(sum[layer+1][i], sum[layer+1][i+1]) + triangle.get(layer).get(i);
            }
        }
        return sum[0][0];
    }
}

