package com.caffeaulait.contest.weekly;


import java.util.Arrays;


public class WeeklyContest196 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 1 || arr.length == 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - arr[i-1] != diff){
                return false;
            }
        }
        return true;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int min = getMin(right);
        int max = getMax(left);
        return Math.max(n-min, max);
    }

    int getMin(int[] list){
        int min = Integer.MAX_VALUE;
        for (int num : list){
            if ( num < min) min = num;
        }
        return min;
    }

    int getMax(int[] list){
        int max = Integer.MIN_VALUE;
        for (int num : list){
            if (num > max) max = num;
        }
        return max;
    }
}
