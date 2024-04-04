package com.caffeaulait.problemset;

import java.util.*;

public class _0621_TaskScheduler {
    /**
     * You are given an array of CPU tasks, each represented by letters A to Z,
     * and a cooling time, n. Each cycle or interval allows the completion of one task.
     * Tasks can be completed in any order, but there's a constraint: identical tasks
     * must be separated by at least n intervals due to cooling time.
     * Return the minimum number of intervals required to complete all tasks.
     *
     *
     * Example 1:
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     *
     * Output: 8
     *
     * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
     *
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task,0)+1);
        }
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            while ( k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue()-1);
                list.add(entry);
                k--;
                count++;
            }
            for (Map.Entry<Character, Integer> entry : list) {
                if (entry.getValue() > 0) pq.add(entry);
            }
            if (pq.isEmpty()) break;
            count += k;
        }
        return count;
    }

}
