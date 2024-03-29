package com.caffeaulait.problemset;

public class _0009_PalindromeNumber {
    /**
     * #9
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     *
     * Could you solve it without converting the integer to a string?
     */

    public boolean isPalindrome(int x) {
        if(x<0 || (x % 10 ==0 && x != 0)) return false;

        String str = String.valueOf(x);

        int i = 0, j = str.length()-1;

        while (i < j){
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

}
