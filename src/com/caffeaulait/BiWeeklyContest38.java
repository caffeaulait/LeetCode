package com.caffeaulait;


import java.util.*;

public class BiWeeklyContest38 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            List<Integer> list;
            if (!sortedMap.containsKey(entry.getValue())) {
                list = new ArrayList<>();
            }else {
                list = sortedMap.get(entry.getValue());
            }
            list.add(entry.getKey());
            sortedMap.put(entry.getValue(), list);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer k : sortedMap.keySet()) {
            List<Integer> list = sortedMap.get(k);
            res.addAll(helper(list, k));
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public List<Integer> helper(List<Integer> list, int freq) {
        list.sort((a, b) -> (b - a));
        List<Integer> res = new ArrayList<>();
        for (int el : list) {
            for (int i = 0; i < freq; i++) res.add(el);
        }
        return res;
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int max = Integer.MIN_VALUE;
        int[] xAxis = new int[points.length];
        for (int i = 0; i < points.length; i++){
            xAxis[i] = points[i][0];
        }
        Arrays.sort(xAxis);
        for (int i = 0; i < xAxis.length - 1; i++) {
            int diff = Math.abs(xAxis[i+1] - xAxis[i]);
            max = Math.max(max, diff);
        }
        return max;
    }
}
