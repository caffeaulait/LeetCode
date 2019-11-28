package com.caffeaulait;

public class _0007_ReverseInteger {
    /**
     * #7
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     * Input: 123
     * Output: 321
     *
     * Example 2:
     * Input: -123
     * Output: -321
     *
     * Example 3:
     * Input: 120
     * Output: 21
     *
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */

    public int reverse(int x){
        //integer range -2147483648 ~ 2147483647
        int result = 0;
        while (x != 0){
            int remainder = x % 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            result = result * 10 + remainder;
            x = x / 10;
        }

        return result;
    }

}
