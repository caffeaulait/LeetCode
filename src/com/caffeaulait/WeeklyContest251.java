package com.caffeaulait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeeklyContest251 {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c-'a');
        }
        return getInt(sb.toString(), k);
    }

    public int getInt(String s, int k) {
        int result = 0;
        String ss = s;
        for (int i = 0; i < k; i++) {
            result = 0;
            for (char c : ss.toCharArray()) {
                result += Integer.parseInt(String.valueOf(c));
            }
            ss = String.valueOf(result);
        }
        return result;
    }

    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean isChanged = false;
        boolean canNot = false;
        for (; i < num.length(); i++) {
            char c = num.charAt(i);
            int digit = c - '0';
            if (change[digit] <= digit) {
                sb.append(digit);
                if (isChanged) canNot = true;
            } else {
                if (canNot) {
                    sb.append(digit);
                } else {
                    sb.append(change[digit]);
                    isChanged = true;
                }
            }
        }
        return sb.toString();
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        List<int[]> stds = new ArrayList<>(Arrays.asList(students));
        List<int[]> mts = new ArrayList<>(Arrays.asList(mentors));
        return helper(stds, mts);
    }

    public int helper(List<int[]> students, List<int[]> mentors) {
        if (students.size() == 0 || mentors.size() == 0) return 0;
        int res = 0;
        int size = mentors.size();
        for (int j = 0; j < size; j++) {
            int[] removed = mentors.remove(j);
            int curr = calcScore(students.get(0), removed) + helper(students.subList(1, students.size()), mentors);
            res = Math.max(res, curr);
            mentors.add(j, removed);
        }
        return res;
    }

    public int calcScore(int[] student, int[] mentor) {
        int result = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) result++;
        }
        return result;
    }
}
