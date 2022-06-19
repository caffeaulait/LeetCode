package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0567_PermuationInString {
    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
     *
     *
     *
     * Example 1:
     *
     * Input: s1 = "ab" s2 = "eidbaooo"
     * Output: True
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Example 2:
     *
     * Input:s1= "ab" s2 = "eidboaoo"
     * Output: False
     */

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0)+1);
            map.put(c2, map.getOrDefault(c2, 0)-1);
        }
        if(allZero(map)) return true;
        for (int i = l1; i < l2; i++) {
            char c1 = s2.charAt(i-l1), c2 = s2.charAt(i);
            map.put(c2, map.getOrDefault(c2, 0)-1);
            map.put(c1, map.getOrDefault(c1, 0)+1);
            if (allZero(map)) return true;
        }
        return false;
    }

    public boolean allZero(Map<Character, Integer> map) {
        for (int v : map.values()) {
            if (v != 0) return false;
        }
        return true;
    }
}
