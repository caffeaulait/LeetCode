package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0844_BackspaceStringCompare {
    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     *
     * Example 1:
     *
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     *
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     *
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     *
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     */
    public boolean backspaceCompare(String S, String T) {
        return removeHash(S).equals(removeHash(T));
    }

    public String removeHash(String s){
        StringBuilder result = new StringBuilder();
        int count = 0, n = s.length();
        for (int i = n - 1;i>=0;i--){
            char c = s.charAt(i);
            if (c == '#'){
                count++;
            }else{
                if (count>0) count--;
                else result.append(c);
            }
        }
        return result.toString();
    }
}
