package com.caffeaulait.contest.weekly;

import java.util.HashMap;
import java.util.Map;

public class WeeklyContest266 {

    public int countVowelSubstrings(String word) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length()-4; i++) {
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    map.put(ch, map.getOrDefault(ch,0)+1);
                    if (map.size() == 5) count++;
                }else{
                    break;
                }
            }
            map.clear();
        }
        return count;
    }

    public long countVowels(String word) {
        long count = 0;
        long subCount = 0;
        for (int i = 0; i < word.length(); i++) {
            subCount = 0;
            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if (isVowel(c)) subCount = subCount*2+1;
                else subCount*=2;
            }
            count += subCount;
        }
        return count;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
