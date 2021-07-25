package com.caffeaulait.contest.biweekly;

import java.util.*;

public class BiWeeklyContest32 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int findKthPositive(int[] arr, int k) {
        int large = arr[arr.length-1];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= large; i++){
            set.add(i);
        }
        for (int el : arr) {
            if (set.contains(el)) set.remove(el);
        }
        if (set.size() == 0) {
            while (k > 0) {
                large++;
                k--;
            }
            return large;
        }else{
            for (int el : set) {
                k--;
                if (k == 0) return el;
            }
            while (k > 0) {
                large++;
                k--;
            }
            return large;
        }
    }

    public boolean canConvertString(String s, String t, int k) {
        if (t.length() != s.length()) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int cost = 0;
        for (int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            int dist = ct - cs;
            if (dist == 0) continue;
            if (dist < 0) dist+=26;
            map.put(dist, map.getOrDefault(dist, 0) + 1);
            cost = Math.max(cost, (map.get(dist) - 1) * 26 + dist);
            if (cost > k) return false;
        }
        return true;
    }

    public int minInsertions(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++ ){
            if (s.charAt(i) == '(') left++;
            else right++;
        }
        if (right == left * 2) return 0;
        while (left >= 1 && right >= 2) {
            left--;
            right-=2;
        }
        if (right == 0) return left*2;
        if (left == 0) return 1 + (1 + right) / 2;
        else return left * 2 - 1;
    }
}
