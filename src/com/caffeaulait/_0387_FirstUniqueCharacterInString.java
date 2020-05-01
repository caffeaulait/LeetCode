package com.caffeaulait;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class _0387_FirstUniqueCharacterInString {
    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, -1);
            else map.put(c, i);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != -1) return map.get(c);
        }
        return -1;
    }
}
