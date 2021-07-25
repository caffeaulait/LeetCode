package com.caffeaulait.problemset;

import java.util.Stack;

public class _0227_BasicCalculatorII {

    /**
     * Given a string s which represents an expression, evaluate this expression and return its value.
     *
     * The integer division should truncate toward zero.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
     *
     *
     *
     * Example 1:
     *
     * Input: s = "3+2*2"
     * Output: 7
     * Example 2:
     *
     * Input: s = " 3/2 "
     * Output: 1
     * Example 3:
     *
     * Input: s = " 3+5 / 2 "
     * Output: 5
     */

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c -'0';
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == len-1) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation =='-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    stack.push(stack.pop()*num);
                } else if (operation == '/') {
                    stack.push(stack.pop()/num);
                }
                operation = c;
                num = 0;
            }
        }
        return stack.stream().mapToInt(i->i).sum();
    }
}
