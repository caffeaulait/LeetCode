package com.caffeaulait.problemset;

import java.util.*;

public class _0451_SortCharactersByFrequency {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     *
     * Example 1:
     *
     * Input:
     * "tree"
     *
     * Output:
     * "eert"
     *
     * Explanation:
     * 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input:
     * "cccaaa"
     *
     * Output:
     * "cccaaa"
     *
     * Explanation:
     * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     *
     * Input:
     * "Aabb"
     *
     * Output:
     * "bbAa"
     *
     * Explanation:
     * "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     */
    public String frequencySort(String s) {
        if (s == null || s.length()==0) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
