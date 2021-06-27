package com.caffeaulait;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WeeklyContest247 {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-1] * nums[len-2] - nums[0] * nums[1];
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        return null;
    }

    public long wonderfulSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i+1; j <= word.length(); j++) {
                String candidate = word.substring(i, j);
                if (checkWonderful(candidate)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkWonderful(String s) {
        int[] counts = new int[10];
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
        int result = 0;
        for (int count : counts) {
            result += count % 2;
        }
        return result <= 1;
    }
}
