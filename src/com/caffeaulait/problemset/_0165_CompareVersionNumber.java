package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0165_CompareVersionNumber {
    /**
     * Given two version numbers, version1 and version2, compare them.
     *
     * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
     *
     * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
     *
     * Return the following:
     *
     * If version1 < version2, return -1.
     * If version1 > version2, return 1.
     * Otherwise, return 0.
     *
     *
     * Example 1:
     *
     * Input: version1 = "1.01", version2 = "1.001"
     * Output: 0
     * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
     * Example 2:
     *
     * Input: version1 = "1.0", version2 = "1.0.0"
     * Output: 0
     * Explanation: version1 does not specify revision 2, which means it is treated as "0".
     * Example 3:
     *
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
     * Example 4:
     *
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * Example 5:
     *
     * Input: version1 = "7.5.2.4", version2 = "7.5.3"
     * Output: -1
     */

    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        List<String> list1 = new ArrayList<>(Arrays.asList(str1));
        List<String> list2 = new ArrayList<>(Arrays.asList(str2));
        int size1 = list1.size(), size2= list2.size();
        int diff = size1 - size2;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) list2.add("0");
        } else {
            diff = Math.abs(diff);
            for (int i = 0; i < diff; i++) list1.add("0");
        }
        for (int i = 0; i < list1.size(); i++) {
            String s1 = removeZeros(list1.get(i));
            String s2 = removeZeros(list2.get(i));
            Integer i1 = Integer.parseInt(s1);
            Integer i2 = Integer.parseInt(s2);
            if (i1 > i2) {
                return 1;
            }else if (i1 < i2){
                return -1;
            }else {
            }
        }
        return 0;
    }

    public String removeZeros(String s) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                idx = i;
                break;
            }
        }
        return s.substring(idx);
    }
}
