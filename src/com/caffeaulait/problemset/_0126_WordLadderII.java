package com.caffeaulait.problemset;

import java.util.*;

public class _0126_WordLadderII {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return an empty list if there is no such transformation sequence.
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
     * Output:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: []
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> neighboursMap = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, dict, neighboursMap, distance);
        dfs(beginWord, endWord, neighboursMap, distance, new ArrayList<>(),
                res);
        return res;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String,
            List<String>> neighboursMap, Map<String, Integer> distance){
        for (String s : dict){
            neighboursMap.put(s, new ArrayList<>());
        }
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);

        while (!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for (int i = 0; i < size; i++){
                String curr = q.poll();
                int currDist = distance.get(curr);
                List<String> neighbours = getNeighbours(curr, dict);
                for (String neighbour : neighbours) {
                    neighboursMap.get(curr).add(neighbour);
                    if (!distance.containsKey(neighbour)) {
                        distance.put(neighbour, currDist + 1);
                        if (end.equals(neighbour)) found = true;
                        else q.offer(neighbour);
                    }
                }
            }
            if (found) break;
        }
    }

    private List<String> getNeighbours(String str, Set<String> dict){
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            for (char c = 'a'; c <= 'z'; c++){
                if (chars[i] == c) continue;;
                char temp = chars[i];
                chars[i] = c;
                if (dict.contains(String.valueOf(chars))) res.add(String.valueOf(chars));
                chars[i] = temp;
            }
        }
        return res;
    }

    private void dfs(String curr, String end, Map<String,
            List<String>> neighboursMap, Map<String, Integer> distance,
                     List<String> solution, List<List<String>> res) {
        solution.add(curr);
        if (end.equals(curr)){
            res.add(new ArrayList<>(solution));
        }else{
            for (String neighbour : neighboursMap.get(curr)) {
                if (distance.get(curr) + 1 == distance.get(neighbour)){
                    dfs(neighbour, end, neighboursMap, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size()-1);
    }
}
