package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0076_MinimumWindowSubstring {
    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     *
     * Example:
     *
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * Note:
     *
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0;
        int count = t.length();
        int minStart = 0, minLen = s.length()+1;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) > 0) count--;
            map.put(c, map.getOrDefault(c, 0) -1);
            end++;
            while (count == 0 && start < s.length()){
                char ch = s.charAt(start);
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                map.put(ch, map.getOrDefault(ch,0)+1);
                if (map.get(ch) > 0) count++;
                start++;
            }
        }
        if (minLen <= s.length()) return s.substring(minStart, minStart+minLen);
        return "";
    }
}
