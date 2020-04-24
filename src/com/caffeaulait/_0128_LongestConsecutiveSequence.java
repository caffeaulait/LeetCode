package com.caffeaulait;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * Your algorithm should run in O(n) complexity.
     *
     * Example:
     *
     * Input: [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestStreak = 1;
        int currStreak = 1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currStreak++;
                }else{
                    longestStreak = Math.max(currStreak,longestStreak);
                    currStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currStreak);
    }
}
