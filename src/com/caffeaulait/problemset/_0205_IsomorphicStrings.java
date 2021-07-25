package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0205_IsomorphicStrings {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     * Output: true
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);
            if (indexS != indexT) return false;
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        return true;
    }
}
