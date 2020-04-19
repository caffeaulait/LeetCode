package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0077_Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     *
     * Example:
     *
     * Input: n = 4, k = 2
     * Output:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(),1, n, k);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= n;i++){
                list.add(i);
                backTrack(result, list, i+1, n, k-1);
                list.remove(list.size()-1);
            }
        }
    }
}
