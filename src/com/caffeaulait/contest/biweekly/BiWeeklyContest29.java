package com.caffeaulait.contest.biweekly;

import java.util.ArrayList;
import java.util.List;

public class BiWeeklyContest29 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */

    public double average(int[] salary) {
        int min = salary[0];
        int max = min;
        int sum = 0;
        for (int sal : salary) {
            if (min < sal) min = sal;
            if (max > sal) max = sal;
            sum += sal;
        }
        sum -= min;
        sum -= max;
        return (sum*1.0) / (salary.length-2);
    }

    public int kthFactor(int n, int k) {
        int curr = 0;
        for (int i = 1; i <=n; i++){
            if (n % i == 0) curr++;
            if (curr == k) return i;
        }
        return -1;
    }

    public int longestSubarray(int[] nums) {
        int curr = 0;
        int max = 0;
        int zeros = 0;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            if (nums[i] == 1) {
                curr++;
                max = Math.max(max, curr);
            }
            else {
                list.add(i);
                zeros++;
                if (zeros == 2) {
                    max = Math.max(max, curr);
                    curr = 0;
                    zeros = 0;
                    i = list.get(list.size()-2);
                    list.remove(list.size()-1);
                }
            }
            i++;
        }
        if (list.size() == 0 || list.size() == 1) return nums.length-1;
        return max;
    }
}
