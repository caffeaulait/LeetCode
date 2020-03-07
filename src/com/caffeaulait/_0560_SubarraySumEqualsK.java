package com.caffeaulait;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK {
    /**
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        map.put(0,1);
        for (int el : nums){
            sum+=el;
            if (map.containsKey(sum-k)) result+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
