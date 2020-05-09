package com.caffeaulait;

public class _0367_ValidPerfectSquare {
    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     *
     * Note: Do not use any built-in library function such as sqrt.
     *
     * Example 1:
     *
     * Input: 16
     * Output: true
     * Example 2:
     *
     * Input: 14
     * Output: false
     */

    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo<=hi) {
            long mid = (lo+hi)>>>1;
            if (mid * mid == num) return true;
            else if (mid * mid < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
