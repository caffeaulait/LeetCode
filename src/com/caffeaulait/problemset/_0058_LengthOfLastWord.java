package com.caffeaulait.problemset;

public class _0058_LengthOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
     *
     * If the last word does not exist, return 0.
     *
     * Note: A word is defined as a maximal substring consisting of non-space characters only.
     *
     * Example:
     *
     * Input: "Hello World"
     * Output: 5
     */

    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) return 0;
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
}
