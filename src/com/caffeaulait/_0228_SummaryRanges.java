package com.caffeaulait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0228_SummaryRanges {
    /**
     * You are given a sorted unique integer array nums.
     *
     * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
     *
     * Each range [a,b] in the list should be output as:
     *
     * "a->b" if a != b
     * "a" if a == b
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * Explanation: The ranges are:
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * Example 2:
     *
     * Input: nums = [0,2,3,4,6,8,9]
     * Output: ["0","2->4","6","8->9"]
     * Explanation: The ranges are:
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     * Example 3:
     *
     * Input: nums = []
     * Output: []
     * Example 4:
     *
     * Input: nums = [-1]
     * Output: ["-1"]
     * Example 5:
     *
     * Input: nums = [0]
     * Output: ["0"]
     */

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) return Arrays.asList(String.valueOf(nums[0]));
        int prev = nums[0];
        List<Integer> list = new ArrayList<>();
        list.add(prev);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr - prev != 1) {
                lists.add(list);
                list = new ArrayList<>();
            }
            list.add(curr);
            prev = curr;
        }
        lists.add(list);
        for (List<Integer> ls : lists) {
            if (ls.size()==1) res.add(String.valueOf(ls.get(0)));
            else res.add(ls.get(0)+"->"+ls.get(ls.size()-1));
        }
        return res;
    }
}
