package com.caffeaulait.contest.biweekly;

import java.util.*;

public class BiWeeklyContest27 {
    /**
     * q1   pass
     * q2
     * q3
     * q4
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            if (!map.containsKey(num)) return false;
            else if (map.get(num) == 1) map.remove(num);
            else map.put(num, map.get(num) - 1);
        }
        return map.isEmpty();
    }

    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        int count = (int)Math.pow(2, k);
        if (len - 1 < count) return false;
        List<String> codes = new ArrayList<>();
        permuations(k, codes, new ArrayList<>());
        for (String code : codes) {
            if (!s.contains(code)) return false;
        }
        return true;
    }

    private void permuations(int k, List<String> result, List<Character> list){
        if (k == 0) {
            result.add(listToString(list));
        }else{
            int size = list.size();
            list.add('0');
            permuations(k - 1, result, list);
            myRemove(list, size);
            list.add('1');
            permuations(k - 1, result, list);
        }

    }

    private String listToString(List<Character> list){
        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }

    private void myRemove(List<Character> list, int start){
        for (int i = list.size()-1; i >= start; i--){
            list.remove(i);
        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] pre = new Set[n];
        List<Boolean> result = new ArrayList<>();
        for (int[] prerequisite: prerequisites) {
            int prev = prerequisite[0];
            int next = prerequisite[1];
            pre[prev].add(next);
        }

        for (int[] query : queries){
            int prev = query[0];
            int next = query[1];
            if (pre[prev].contains(next)) result.add(true);
            else result.add(false);
        }
        return result;
    }
}
