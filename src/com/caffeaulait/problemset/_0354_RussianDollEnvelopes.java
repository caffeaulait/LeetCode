package com.caffeaulait.problemset;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _0354_RussianDollEnvelopes {
    /**
     * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
     *
     * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
     *
     * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
     *
     * Note: You cannot rotate an envelope.
     *
     *
     *
     * Example 1:
     *
     * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * Output: 3
     * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     * Example 2:
     *
     * Input: envelopes = [[1,1],[1,1],[1,1]]
     * Output: 1
     */

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            }else if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return 1;
            }
        });
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int piles = 0;
        int[] top = new int[nums.length];
        for (int num : nums) {
            int left = 0, right = piles-1;
            //find left bound
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(top[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //find the right place to insert num
            top[left] = num;
            if (left == piles) piles++;
        }
        return piles;
    }
}
