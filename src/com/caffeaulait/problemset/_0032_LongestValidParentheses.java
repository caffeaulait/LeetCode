package com.caffeaulait.problemset;

import java.util.Stack;

public class _0032_LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     *
     * Example 1:
     *
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * Example 2:
     *
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     */

    public int longestValidParentheses(String s) {
        int max = 0, n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek())=='(') stack.pop();
                else stack.push(i);
            }
        }
        if (stack.isEmpty()) return n;
        else {
            int left = 0, right = n;
            while (!stack.isEmpty()) {
                left = stack.pop();
                max = Math.max(max, right - left - 1);
                right = left;
            }
            return Math.max(max, right);
        }
    }
}
