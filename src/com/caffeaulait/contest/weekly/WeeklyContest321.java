package com.caffeaulait.contest.weekly;


import java.util.*;

public class WeeklyContest321 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char[][] chars = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            chars[i] = new char[]{s.charAt(0), s.charAt(s.length()-1)};
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i][0] != chars[i-1][1]) {
                return false;
            }
        }
        return chars[0][0] == chars[chars.length - 1][1];
    }

    public static long dividePlayers(int[] skill) {
        int sum = 0;
        for (int s : skill) sum += s;
        int n = skill.length / 2;
        if (sum % n != 0) return -1;
        int subSum = sum / n;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int[][] pairs = new int[n][2];
        boolean[] taken = new boolean[skill.length];
        int j = 0;
        for (int i = 0; i < skill.length; i++) {
            if (taken[i]) continue;
            int s = skill[i];
            Queue<Integer> queue;
            if (map.containsKey(subSum - s) && map.get(subSum - s).size() > 0) {
                queue = map.get(subSum - s);
                int idx = queue.poll();
                taken[i] = true;
                taken[idx] = true;
                pairs[j++] = new int[]{s, subSum-s};
            } else {
                queue = new LinkedList<>();
                queue.offer(i);
            }
            map.put(s, queue);
        }
        long product = 0;
        for (int[] pair : pairs) {
            System.out.printf("%d - %d\n", pair[0], pair[1]);
            if (pair[0] == 0 || pair[1] == 0) {
                return -1;
            }
            product += pair[0] * pair[1];
        }
        return product;
    }

    public static void main(String[] args) {
        int[]skill = {2,3,4,2,5,5};
        System.out.println(dividePlayers(skill));
    }
}
