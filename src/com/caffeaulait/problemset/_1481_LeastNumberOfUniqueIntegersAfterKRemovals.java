package com.caffeaulait.problemset;

import java.util.*;

public class _1481_LeastNumberOfUniqueIntegersAfterKRemovals {
    /**
     * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [5,5,4], k = 1
     * Output: 1
     * Explanation: Remove the single 4, only 5 is left.
     * Example 2:
     * Input: arr = [4,3,1,1,3,3,2], k = 3
     * Output: 2
     * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> (b.getValue() - a.getValue()));
        int i = list.size() - 1;
        for (; i >= 0; i--) {
            int count = list.get(i).getValue();
            if (k >= count) {
                k -= count;
            } else {
                break;
            }
        }
        return i + 1;
    }
}
