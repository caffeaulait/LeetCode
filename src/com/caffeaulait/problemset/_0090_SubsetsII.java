package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_SubsetsII {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list , int[] nums, int start){
        result.add(new ArrayList<>(list));
        for (int i = start;i<nums.length;i++){
            if (i>start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            backTrack(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
