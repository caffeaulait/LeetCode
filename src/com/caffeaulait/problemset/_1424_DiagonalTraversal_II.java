package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1424_DiagonalTraversal_II {
    /**
     * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
     *
     *
     * Example 1:
     *
     *
     * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,4,2,7,5,3,8,6,9]
     * Example 2:
     *
     *
     * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
     * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                count++;
                int sum = i + j;
                max = Math.max(max, sum);
                if(!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(nums.get(i).get(j));
            }
        }
        int[] result = new int[count];
        int k = 0;
        for (int i = 0; i <= max; i++) {
            List<Integer> list = map.get(i);
            for (int j = list.size()-1; j >=0; j--) {
                result[k++] = list.get(j);
            }
        }
        return result;
    }
}
