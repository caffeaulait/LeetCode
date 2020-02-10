package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0039_CombinationSum {
    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
     * combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     *
     * */

    //https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start){
        if (target < 0){
            return;
        }else if (target == 0){
            result.add(new ArrayList<>(list));
        }else{
            for (int i = start; i< candidates.length;i++){
                list.add(candidates[i]);
                backTrack(result, list, candidates, target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }
}
