package com.caffeaulait;

public class _0395_LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
     * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
     *
     * Example 1:
     *
     * Input:
     * s = "aaabb", k = 3
     *
     * Output:
     * 3
     *
     * The longest substring is "aaa", as 'a' is repeated 3 times.
     * Example 2:
     *
     * Input:
     * s = "ababbc", k = 2
     *
     * Output:
     * 5
     *
     * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */

    public int longestSubstring(String s, int k) {
        if ( s == null || s.length() == 0) return 0;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) chars[s.charAt(i)-'a']++;
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0 && chars[i] < k) {
                flag = false;
                break;
            }
        }
        if (flag) return s.length();
        int res = 0;
        int start = 0, curr = 0;
        while (curr < s.length()) {
            if (chars[s.charAt(curr) - 'a'] < k){
                res = Math.max(res, longestSubstring(s.substring(start, curr)
                        , k));
                start = curr + 1;
            }
            curr++;
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;

    }
}
