package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0017_LetterCombinationsOfPhoneNumber {
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     */
    private String[] pad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> add(String str, List<String> list){
        List<String> res= new ArrayList<>();

        char[] chr =str.toCharArray();
        for (char c: chr ) {
            for(String s:list){
                res.add(s+c);
            }
        }
        return res;
    }

    public List<String> letterCombinations(String digits){
        List<String> ans =new ArrayList<>();
        if(digits==null||digits.isEmpty()) return ans;

        ans.add("");
        for (int i=0;i<digits.length();i++ ) {
            ans=add(pad[digits.charAt(i)-'0'],ans);
        }
        return ans;
    }
}
