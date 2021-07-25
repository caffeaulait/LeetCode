package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0229_MajorityElementII {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     *
     * Note: The algorithm should run in linear time and in O(1) space.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: [3]
     * Example 2:
     *
     * Input: [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     */
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : nums){
            map.put(el, map.getOrDefault(el, 0)+1);
        }
        for (int k : map.keySet()){
            if (map.get(k) > size / 3) result.add(k);
        }
        return result;
    }
}
