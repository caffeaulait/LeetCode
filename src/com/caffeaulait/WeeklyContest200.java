package com.caffeaulait;

import java.util.*;

public class WeeklyContest200 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i< arr.length-2; i++){
            for (int j = i + 1; j < arr.length-1; j++){
                for (int k = j + 1; k < arr.length; k++){
                    if (Math.abs(arr[i] - arr[j]) <= a
                    && Math.abs(arr[j] - arr[k]) <= b
                    && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int getWinner(int[] arr, int k) {
        List<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int el : arr) {
            if (el > max) max = el;
            list.add(el);
        }
        if (k >= arr.length) {
            return max;
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (true){
            int first = list.get(0);
            int second = list.get(1);
            if (first > second){
                map.put(first, map.getOrDefault(first,0)+1);
                if (map.get(first) == k) {
                    return first;
                }
                list.remove(1);
                list.add(second);
            }else{
                map.put(second, map.getOrDefault(second,0)+1);
                if (map.get(second) == k){
                    return second;
                }
                list.remove(0);
                list.add(first);
            }
        }
    }
}
