package com.caffeaulait.problemset;



import java.util.HashMap;
import java.util.Map;

public class _0303_RangeSumQuery {
    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     *
     * Example:
     * Given nums = [-2, 0, 3, -5, 2, -1]
     *
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * Note:
     * You may assume that the array does not change.
     * There are many calls to sumRange function.
     */

    private int[] sum;

    public _0303_RangeSumQuery(int[] nums) {
        sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
