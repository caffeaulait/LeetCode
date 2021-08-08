package com.caffeaulait.contest.weekly;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeeklyContest253 {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (sb.length() > s.length()) break;
            else if (sb.length() == s.length()){
                return Objects.equals(s, sb.toString());
            }
        }
        return false;
    }

    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> (b-a));
        for (int pile : piles) queue.offer(pile);
        while ( k > 0) {
            int pile = queue.poll();
            queue.offer((int) Math.round(pile / 2.0));
            k--;
        }
        int result = 0;
        for (int num : queue) result+=num;
        return result;
    }

    public int minSwaps(String s) {
        return 0;
    }
}
