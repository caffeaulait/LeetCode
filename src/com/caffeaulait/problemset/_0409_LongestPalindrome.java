package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0409_LongestPalindrome {
    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     */

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int result = 0;
        for (int num : count) {
            result += num/2*2;
            if (result%2==0 && num % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}
