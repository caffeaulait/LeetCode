package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest193 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            map.put(el, map.getOrDefault(el,0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> (a.getValue() - b.getValue()));
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int result = sortedMap.size();
        for (int key : sortedMap.keySet()){
            int count = sortedMap.get(key);
            if (count <= k) {
                k-=count;
                result--;
            }else{
                break;
            }
        }
        return result;
    }
}
