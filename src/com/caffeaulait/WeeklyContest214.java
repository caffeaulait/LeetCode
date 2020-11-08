package com.caffeaulait;

import java.util.*;

public class WeeklyContest214 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) return n;
        int max = 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            int cur;
            if (i % 2 == 0) {
                cur = list.get(i/2);
            }else {
                cur = list.get(i/2) + list.get(i/2+1);
            }
            list.add(cur);
            max = Math.max(cur, max);
        }
        return max;
    }

    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }
        int count = 0;
        while (pq.size()!=0){
            int f = pq.poll();
            if (pq.size() == 0) return count;
            if (f == pq.peek()) {
                count++;
                if (f>1) pq.offer(f-1);
            }
        }
        return count;
    }

    public int createSortedArray(int[] instructions) {
        if (instructions.length <= 2) return 0;
        List<Integer> list = new ArrayList<>();
        int cost = 0;
        list.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++){
            int cur = instructions[i];
            int less = 0;
            int equal = 0;
            int j = 0;
            for (; j < list.size();j++){
                if (cur > list.get(j)) {
                    less++;
                }
                if (cur == list.get(j)){
                    equal++;
                }
                if (cur < list.get(j)) {
                    break;
                }
            }
            cost += Math.min(less, list.size()-less-equal);
            list.add(j, cur);
        }
        return cost;
    }
}
