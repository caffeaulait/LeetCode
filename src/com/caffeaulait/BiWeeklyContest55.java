package com.caffeaulait;

import java.util.*;
import java.util.stream.Collectors;

public class BiWeeklyContest55 {

    public boolean canBeIncreasing(int[] nums) {
        if (nums.length <= 2) return true;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            list.remove(i);
            if (isIncreasing(list)) {
                return true;
            }
        }
        return false;
    }

    public boolean isIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i-1) <= 0) {
                return false;
            }
        }
        return true;
    }

    public String removeOccurrences(String s, String part) {
        while (true) {
            int prev = s.length();
            s = s.replaceFirst(part, "");
            int curr = s.length();
            if (curr == prev) break;
        }
        return s;
    }

    public long maxAlternatingSum(int[] nums) {
        return 0;
    }
}
