package com.caffeaulait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_PermuationsII {
    /**
     *
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(used,false);
        backTrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i <nums.length; i++){
            if (used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue;
            used[i] = true;
            list.add(nums[i]);
            backTrack(result,list,nums,used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
