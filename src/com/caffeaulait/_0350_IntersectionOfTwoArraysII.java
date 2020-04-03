package com.caffeaulait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0350_IntersectionOfTwoArraysII {
    /**
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : nums1){
            map.put(el, map.getOrDefault(el, 0) +1);
        }

        for (int el : nums2){
            if (map.containsKey(el) && map.get(el) > 0) {
                list.add(el);
                map.put(el, map.get(el)-1);
            }
        }
        return list.stream().filter(el -> el!=null).mapToInt(el -> el).toArray();
    }
}
