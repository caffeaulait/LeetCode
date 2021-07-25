package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest187 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        for (List<String> path : paths) {
            start.add(path.get(0));
            end.add(path.get(1));
        }
        for (String s : end) {
            if (!start.contains(s)) return s;
        }
        return null;
    }

    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) list.add(i);
        }
        if (list.size()==0 || list.size()==1) return true;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) - list.get(i-1) <= k) return false;
        }
        return true;
    }

    public int longestSubarray(int[] nums, int limit) {
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        int i = 0, j = 0;
        int length = 0;
        minHeap.add(nums[0]);
        maxHeap.add(nums[0]);
        while (j < nums.length && i < nums.length){
            int min = minHeap.peek();
            int max = maxHeap.peek();
            if (max - min <= limit) {
                length = Math.max(length, j-i+1);
                if (++j < nums.length) {
                    minHeap.add(nums[j]);
                    maxHeap.add(nums[j]);
                }
            }
            else {
                maxHeap.remove(nums[i]);
                minHeap.remove(nums[i]);
                i++;
            }
        }
        return length;
    }

    public int kthSmallest(int[][] mat, int k) {
        return 0;
    }

}

