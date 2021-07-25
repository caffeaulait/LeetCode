package com.caffeaulait.problemset;

public class _0204_CountPrimes {
    /**
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * Example:
     *
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */

    public int countPrimes(int n){
        if (n < 3) return 0;

        int c = n / 2;

        //true for isComposite, false for isPrime
        boolean[] s = new boolean[n];

        for (int i = 3; i*i < n; i+=2){
            if (s[i]) continue;
            for (int j = i * i; j < n; j+=i*2){
                if (!s[j]){
                    s[j] = true;
                    c--;
                }
            }
        }
        return c;
    }
}
