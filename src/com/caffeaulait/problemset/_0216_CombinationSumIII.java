package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0216_CombinationSumIII {
    /**
     * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     *
     * Note:
     *
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer>list, int k, int n, int start){
        if (list.size() == k && n == 0) {
            result.add(new ArrayList<>(list));

        }else{
            for (int i = start; i < 10; i++) {
                list.add(i);
                backTrack(result, list, k, n-i, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
