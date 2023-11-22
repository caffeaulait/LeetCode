package com.caffeaulait.problemset;

import java.util.Map;
import java.util.HashMap;

public class _1814_CountNicePairsInAnArray {
    /**
     * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
     *
     * 0 <= i < j < nums.length
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
     * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
     *
     * Example 1:
     *
     * Input: nums = [42,11,1,97]
     * Output: 2
     * Explanation: The two pairs are:
     *  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
     *  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
     * Example 2:
     *
     * Input: nums = [13,10,35,24,76]
     * Output: 4
     */

    public int countNicePairs(int[] nums) {
        int res = 0, mod = (int)1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums) {
            int b = rev(a);
            int v = map.getOrDefault(a-b, 0);
            map.put(a-b, v+1);
            res = (res + v) % mod;
        }
        return res;
    }

    public int rev(int num) {
        int res = 0;
        while(num > 0) {
            res = res * 10 + ( num % 10);
            num /= 10;
        }
        return res;
    }
}
