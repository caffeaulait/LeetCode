package com.caffeaulait;

import java.util.HashMap;
import java.util.Map;

public class _0169_MajorityElement {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : nums){
            map.put(el, map.getOrDefault(el,0)+1);
        }
        for (int k : map.keySet()){
            if (map.get(k) > nums.length/2) return k;
        }
        return -1;
    }
}
