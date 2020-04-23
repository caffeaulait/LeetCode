package com.caffeaulait;

public class _0201_BitwiseAndOfNumbersRange {
    /**
     * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
     *
     * Example 1:
     *
     * Input: [5,7]
     * Output: 4
     * Example 2:
     *
     * Input: [0,1]
     * Output: 0
     */

    public int rangeBitwiseAnd(int m, int n) {
        /**
         * equivalent to find the common prefix of same length m and n 's binary code.
         * e.g.
         * 0011010
         * 1111110
         *
         * common prefix is 0 (not 11)
         */
        int shift = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
