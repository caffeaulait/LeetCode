package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest318 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = nums[i+1] * 2;
                nums[i+1] = 0;
            }
        }
        int i = 0, j = 0;
        while ( i < nums.length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j < nums.length) nums[j++] = 0;
        return nums;
    }

    public long maximumSubarraySum(int[] nums, int k) {
        if(nums.length < k) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        long max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            sum += nums[i];
            if (i >= k) {
                map.put(nums[i-k], map.get(nums[i-k])-1);
                sum -= nums[i-k];
                if (map.get(nums[i-k]) == 0) {
                    map.remove(nums[i-k]);
                }
            }
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
