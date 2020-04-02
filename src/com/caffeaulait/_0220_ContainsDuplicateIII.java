package com.caffeaulait;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _0220_ContainsDuplicateIII {
    /**
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            if (i > k) set.remove((long)nums[i-k-1]);
            Long floor = set.floor((long)nums[i]);
            Long ceil = set.ceiling((long)nums[i]);
            if ((floor!=null && nums[i] - floor <= t) || (ceil!=null && ceil - nums[i] <= t)) return true;
            set.add((long)nums[i]);
        }
        return false;
    }
}
