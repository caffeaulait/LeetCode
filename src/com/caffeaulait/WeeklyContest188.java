package com.caffeaulait;

import java.util.*;

public class WeeklyContest188 {
    /**
     * q1   pass
     * q2   pass
     * q3   unsolved
     * q4   unsolved
     */

    public List<String> buildArray(int[] target, int n) {
        List<String> list= new LinkedList<>();
        if (target.length == 0) return list;
        int max = target[target.length-1];
        int i = 1, j = 0;
        while (i <= max && j < target.length) {
            if (target[j] == i) {
                list.add("Push");
                j++;
            }else {
                list.add("Push");
                list.add("Pop");
            }
            i++;
        }
        return list;
    }

    public int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    sum ^= arr[k];
                }
                if (sum == 0) count += (j - i);
            }
        }
        return count;
    }

}
