package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0168_ExcelSheetColumnTitle {
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     *
     * For example:
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * Example 1:
     *
     * Input: 1
     * Output: "A"
     * Example 2:
     *
     * Input: 28
     * Output: "AB"
     * Example 3:
     *
     * Input: 701
     * Output: "ZY"
     */

    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while ( n > 0) {
            n--;
            res.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return res.toString();
    }
}
