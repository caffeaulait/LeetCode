package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _0540_SingleElementInSortedArray {
    /**
     * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     *
     * Input: [3,3,7,7,10,11,11]
     * Output: 10
     */

    public int singleNonDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) set.remove(num);
        }
        return set.iterator().next();
    }
}
