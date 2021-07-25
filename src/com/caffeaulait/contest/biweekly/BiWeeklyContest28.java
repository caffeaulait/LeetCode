package com.caffeaulait.contest.biweekly;

import java.util.ArrayList;
import java.util.List;

public class BiWeeklyContest28 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length-1; i++)
            for (int j = i+1; j < prices.length; j++){
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        return prices;
    }

    class SubrectangleQueries {
        int[][] rect;

        public SubrectangleQueries(int[][] rectangle) {
            rect = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++){
                for (int j = col1; j <= col2; j++) {
                    rect[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rect[row][col];
        }
    }

    public static int minSumOfLengths(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            int sum = arr[i];
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            if (arr[i] == target) {
                result.add(list);
                continue;
            }
            for (int j = i+1; j < arr.length; j++){
                sum += arr[j];
                list.add(arr[j]);
                if (sum == target) {
                    result.add(list);
                    break;
                }
            }
        }
        System.out.println(result);
        if (result.size() < 2) {
            return -1;
        }
        else {
            result.sort((a,b) -> (a.size()-b.size()));
            return result.get(0).size()+result.get(1).size();
        }
    }

}
