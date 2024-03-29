package com.caffeaulait.problemset;

public class _0541_ReverseStringII {
    /**
     * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     */

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int i = 0;
        while (i  < size) {
            int end = k + i -1;
            if (end >= size) end = size-1;
            reverse(chars, i, end);
            i+=2*k;
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] s, int start, int end){
        while (start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
