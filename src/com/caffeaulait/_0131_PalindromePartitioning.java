package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backTrack(List<List<String>> result, List<String> list, String s, int start){
        if (start == s.length()){
            result.add(new ArrayList<>(list));
        }else{
            for (int i = start; i< s.length();i++){
                if (isPalindrome(s,start,i)){
                    list.add(s.substring(start,i+1));
                    backTrack(result,list,s,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
