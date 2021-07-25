package com.caffeaulait.problemset;

import java.util.Stack;

public class _0020_ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     */

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('||ch == '{'||ch == '['){
                stk.push(ch);
            }
            else if(ch == ')'){
                if(stk.empty()||stk.peek()!='(')
                    return false;
                else
                    stk.pop();
            }
            else if(ch == '}'){
                if(stk.empty()||stk.peek()!='{')
                    return false;
                else
                    stk.pop();
            }
            else if(ch == ']'){
                if(stk.empty()||stk.peek()!='[')
                    return false;
                else
                    stk.pop();
            }
        }

        if(!stk.empty())
            return false;
        else
            return true;
    }
}
