package com.caffeaulait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0030_SubstringWithConcatenationOfAllWords {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     *
     *
     *
     * Example 1:
     *
     * Input:
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     * Output: [0,9]
     * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
     * The output order does not matter, returning [9,0] is fine too.
     * Example 2:
     *
     * Input:
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * Output: []
     */
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> seen;
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return list;
        for (String word : words) count.put(word, count.getOrDefault(word, 0) + 1 );
        int m = words.length, len = words[0].length(), n = s.length();
        for (int i = 0; i < n - m*len + 1; i++){
            seen = new HashMap<>();
            int j = 0;
            while ( j < m ) {
                String str = s.substring(i+ j*len, i + (j+1)*len);
                if (count.containsKey(str)) {
                    seen.put(str, seen.getOrDefault(str, 0) + 1);
                    if (seen.get(str) > count.get(str)) break;
                } else {
                    break;
                }
                j++;
            }
            if (j == m) list.add(i);
        }
        return list;
    }
}
