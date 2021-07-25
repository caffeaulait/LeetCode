package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _0003_LongestSubstringWithoutRepeatingCharacters {

    /**
     * #3
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    //brute force
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j= i+1; j <= n; j++){
                if(isUnique(s.substring(i,j))) result = Math.max(result,j-i);
            }
        }
        return result;
    }

    public boolean isUnique(String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<s.length();i++){
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    //sliding window
    public int $lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0 , j = 0;
        while (i < n && j < n){
            if (! set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    //optimized sliding window
    public int $$lengthOfLongestSubstring(String s){
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0,j=0;j<s.length();j++){
            char c = s.charAt(j);
            if (map.containsKey(c)){
                i = Math.max(i,map.get(c)+1);
            }
            map.put(c,j);
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}
