package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest220 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public String reformatNumber(String number) {
        number = number.replaceAll("\\s", "");
        number = number.replaceAll("-", "");
        int len = number.length();
        System.out.println(number);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i+=3) {
            if (len - i == 4) {
                list.add(number.substring(i, i + 2));
                list.add(number.substring(i + 2, i + 4));
                break;
            }else if (len - i == 2 || len - i == 3){
                list.add(number.substring(i));
            }else {
                list.add(number.substring(i, i + 3));
            }
        }
        return String.join("-", list);
    }

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 1;
        int res = nums[0], curr = nums[0];
        set.add(nums[0]);
        while ( i < nums.length - 1 && j < nums.length) {
            if (!set.contains(nums[j])) {
                curr += nums[j];
                res = Math.max(res, curr);
                set.add(nums[j]);
                j++;
            }else {
                curr -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}
