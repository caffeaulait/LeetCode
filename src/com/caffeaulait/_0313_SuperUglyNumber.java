package com.caffeaulait;

public class _0313_SuperUglyNumber {
    /**
     * Write a program to find the nth super ugly number.
     *
     * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
     *
     * Example:
     *
     * Input: n = 12, primes = [2,7,13,19]
     * Output: 32
     * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
     *              super ugly numbers given primes = [2,7,13,19] of size 4.
     */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] pv = new int[primes.length];
        int[] ps = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i ++){
            int ugly = 0;
            for (int j = 0; j < primes.length; j++){
                pv[j] = dp[ps[j]] * primes[j];
                ugly = findMin(pv);
            }
            for (int j = 0; j < primes.length; j++){
                if (ugly == pv[j]) ps[j]++;
            }
            dp[i] = ugly;
        }
        return dp[n-1];
    }

    private int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
