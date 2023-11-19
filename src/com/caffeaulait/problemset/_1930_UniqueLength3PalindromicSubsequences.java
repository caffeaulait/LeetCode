package com.caffeaulait.problemset;

import java.util.Arrays;

public class _1930_UniqueLength3PalindromicSubsequences {
    /**
     * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
     * <p>
     * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
     * <p>
     * A palindrome is a string that reads the same forwards and backwards.
     * <p>
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * <p>
     * For example, "ace" is a subsequence of "abcde".
     */

    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26], last = new int[26];
        int count = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first[c - 'a'] == Integer.MAX_VALUE) first[c - 'a'] = i;
            last[c - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                count += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return count;
    }
}
