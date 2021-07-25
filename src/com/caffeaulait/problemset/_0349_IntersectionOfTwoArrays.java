package com.caffeaulait.problemset;

import java.util.HashSet;
import java.util.Set;

public class _0349_IntersectionOfTwoArrays {
    /**
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Note:
     *
     * Each element in the result must be unique.
     * The result can be in any order.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int el : nums1) set.add(el);
        for (int el : nums2) {
            if (set.contains(el)) result.add(el);
        }
        return result.stream().filter(t -> t!=null).mapToInt(t->t).toArray();
    }
}
