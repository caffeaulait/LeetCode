package com.caffeaulait.contest.weekly;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.*;

public class WeeklyContest190 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++){
            if (words[i].startsWith(searchWord)) return i+1;
        }
        return -1;
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        if (s.length()<k) return max;
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) max++;
            q.offer(c);
        }
        int curr = max;
        for (int i = k; i < s.length(); i++){
            char oldChar = s.charAt(i-k);
            char newChar = s.charAt(i);
            q.poll();
            q.offer(newChar);
            if (isVowel(oldChar)) curr--;
            if (isVowel(newChar)) curr++;
            max = Math.max(max, curr);
        }
        return max;
    }

    private boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>());
        int count = 0;
        for (List<Integer> list : result) {
            if (isPalindrome(list)) count++;
        }
        return count;
    }

    public void dfs(TreeNode root, List<List<Integer>> result,
                    List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }else{
            List<Integer> copy = new ArrayList<>(list);
            dfs(root.left, result, list);
            dfs(root.right, result, copy);
        }
    }

    public boolean isPalindrome(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for (int el : list){
            if (!set.add(el)) set.remove(el);
        }
        return set.size() == 1 || set.size() == 0;
    }
}
