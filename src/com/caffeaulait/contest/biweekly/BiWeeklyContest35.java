package com.caffeaulait.contest.biweekly;

public class BiWeeklyContest35 {
    /**
     * q1
     * q2
     * q3
     * q4
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += 2) {
                sum += subSum(arr, i, j);
            }
        }
        return sum;
    }

    public int subSum(int[] arr, int i, int j){
        int sum = 0;
        for (int cur = i; cur <= j; cur++){
            sum+=arr[cur];
        }
        return sum;
    }
}
