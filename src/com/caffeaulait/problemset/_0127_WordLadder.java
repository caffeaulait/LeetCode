package com.caffeaulait.problemset;

import java.util.*;

public class _0127_WordLadder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list.
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int layer = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String word = queue.poll();
                if (word.equals(endWord)) return layer;
                for (int j = 0; j < word.length(); j++){
                    for (int k = 0; k < 26; k++){
                        char[] chars = word.toCharArray();
                        chars[j] = (char)('a' + k);
                        String newString = String.valueOf(chars);
                        if (set.contains(newString)) {
                            queue.offer(newString);
                            set.remove(newString);
                        }
                    }
                }
            }
            layer++;
        }
        return 0;
    }
}
