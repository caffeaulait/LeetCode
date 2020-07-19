package com.caffeaulait;

import java.util.*;

public class WeeklyContest198 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            count += empty/numExchange;
            empty = empty / numExchange + empty % numExchange;
        }
        return count;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i,
                new LinkedHashSet<>(Arrays.asList(i)));
        for (int i = n - 2; i >=0 ; i--){
            for (int[] edge : edges){
                if (edge[0] == i) {
                    map.get(i).addAll(map.get(edge[1]));
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.println(map.get(i).size());
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            char root = labels.charAt(i);
            for (int j : map.get(i)) {
                if (labels.charAt(j) == root) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
