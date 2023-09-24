package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0046_Permuations {
    /**
     * Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) return result;
        boolean[] used = new boolean[n];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, result, list, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        Integer[] num = new Integer[nums.length];
        for (int i = 0; i<nums.length;i++){
            num[i] = nums[i];
        }
        List<List<Integer>> result = new ArrayList<>();
        permuation(num,0,result);
        return result;
    }

    public void permuation(Integer[] num, int index, List<List<Integer>> result){
        if (index == num.length-1) {
            List<Integer> list = Arrays.asList(num);
            result.add(new ArrayList<>(list));
        }else{
            for (int j = index;j<num.length;j++){
                swap(num,index,j);
                permuation(num,index+1,result);
                swap(num,index,j);
            }
        }
    }

    public void swap(Integer[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
