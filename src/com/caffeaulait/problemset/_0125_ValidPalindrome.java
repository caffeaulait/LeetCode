package com.caffeaulait.problemset;

public class _0125_ValidPalindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     */

    public boolean isPalindrome(String s) {
        String real = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String reverse = new StringBuffer(real).reverse().toString();
        return real.equals(reverse);
    }
}
