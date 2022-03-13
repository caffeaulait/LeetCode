package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest284 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndex = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int index : keyIndex) {
                if (Math.abs(i-index) <= k) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int[] d : dig) {
            set.add(d[0] + "," + d[1]);
        }
        for (int[] artifact : artifacts) {
            String a1 = artifact[0] + "," + artifact[1];
            String a2 = artifact[2] + "," + artifact[3];
            if (set.contains(a1) && set.contains(a2)) count++;
        }
        return count;
    }

    public int maximumTop(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        while ( k > 1) {
            if (list.size() == 0) {
                break;
            }
            q.add(list.remove(0));
            k--;
        }
        if (q.size() > 0) {
            return q.poll();
        }
        return -1;
    }
}
