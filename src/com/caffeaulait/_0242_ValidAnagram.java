package com.caffeaulait;

public class _0242_ValidAnagram {
    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     */
    public boolean isAnagram(String s, String t) {
        int[] chs = new int[26];
        for (char c : s.toCharArray()) {
            chs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            chs[c - 'a']--;
        }
        for (int el : chs) if (el != 0) return false;
        return true;
    }
}
