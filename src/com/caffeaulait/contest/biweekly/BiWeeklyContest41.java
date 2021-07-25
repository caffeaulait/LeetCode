package com.caffeaulait.contest.biweekly;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BiWeeklyContest41 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */

    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) set.add(c);
        for (String word : words) {
            if (isAllowed(set, word)) res++;
        }
        return res;
    }

    private boolean isAllowed(Set<Character> set, String s) {
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) return false;
        }
        return true;
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int value = 0;
        for (int j = 0; j < nums.length; j++) {
            value += Math.abs(nums[0] - nums[j]);
        }
        res[0] = value;
        for (int i = 1; i < res.length; i++) {
            int diff = nums[i] - nums[i-1];
            value += diff * i - diff * (nums.length - i);
            res[i] = value;
        }
        return res;
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Queue<Integer> aliceQ = new PriorityQueue<>((a,b) -> (b-a));
        Queue<Integer> bobQ = new PriorityQueue<>((a,b) -> (b-a));
        for (int value : aliceValues) aliceQ.add(value);
        for (int value : bobValues) bobQ.add(value);
        int a = 0, b = 0;
        boolean aliceTurn = true;
        for (int i = 0; i < aliceValues.length; i++) {
            if (aliceTurn) {
                a += aliceQ.poll();
                aliceTurn = false;
            }else {
                b += bobQ.poll();
                aliceTurn = true;
            }
        }
        return Integer.compare(a, b);
    }
}
