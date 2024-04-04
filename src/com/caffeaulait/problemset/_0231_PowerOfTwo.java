package com.caffeaulait.problemset;

public class _0231_PowerOfTwo {

    /**
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     *
     * An integer n is a power of two, if there exists an integer x such that n == 2x.
     */

    public boolean isPowerOfTwo(int n) {
        return n > 0 &&  (n&(n - 1)) == 0;
    }
}
