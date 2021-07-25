package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0179_LargestNumber {
    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * Example 1:
     *
     * Input: [10,2]
     * Output: "210"
     * Example 2:
     *
     * Input: [3,30,34,5,9]
     * Output: "9534330"
     * Note: The result may be very large, so you need to return a string instead of an integer.
     */
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if (list.get(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(String.valueOf(num));
        }
        return sb.toString();
    }
}
