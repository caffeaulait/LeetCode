package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0166_FractionToRecurringDecimal {
    /**
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
     *
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     *
     * If multiple answers are possible, return any of them.
     *
     * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
     *
     *
     *
     * Example 1:
     *
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     * Example 2:
     *
     * Input: numerator = 2, denominator = 1
     * Output: "2"
     * Example 3:
     *
     * Input: numerator = 2, denominator = 3
     * Output: "0.(6)"
     * Example 4:
     *
     * Input: numerator = 4, denominator = 333
     * Output: "0.(012)"
     * Example 5:
     *
     * Input: numerator = 1, denominator = 5
     * Output: "0.2"
     */

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append( (numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num /den);
            num %= den;
            if (map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}
