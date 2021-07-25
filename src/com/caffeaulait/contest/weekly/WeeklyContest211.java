package com.caffeaulait.contest.weekly;


import java.util.*;

public class WeeklyContest211 {
    /**
     * q1   pass
     * q2
     * q3
     * q4
     */

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])){
                map.get(chs[i]).add(i);
            }else{
                map.put(chs[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        int curr = -1;
        int max = -1;
        for (Character key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) continue;
            curr = list.get(list.size()-1) - list.get(0) - 1;
            max = Math.max(curr, max);
        }
        return max;
    }
}
