package com.caffeaulait.contest.weekly;

import java.util.*;


public class WeeklyContest212 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int cur = 0, max = 0;
        int[] chs = new int[26];
        char c = keysPressed.charAt(0);
        chs[ c - 'a'] = releaseTimes[0];
        cur = releaseTimes[0];
        max = Math.max(max, cur);
        for (int i = 1; i < releaseTimes.length; i++) {
            c = keysPressed.charAt(i);
            if (releaseTimes[i] - releaseTimes[i-1] > chs[c-'a']){
                chs[c-'a'] = releaseTimes[i] - releaseTimes[i-1];
            }
            cur = chs[c -'a'];
            max = Math.max(max, cur);
        }
        for (int i = 25; i >=0 ; i--){
            if (chs[i] == max) return (char)('a' + i);
        }
        return c;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++){
            int start = l[i], end = r[i];
            res.add(isValid(nums,start,end));
        }
        return res;
    }

    public boolean isValid(int[] nums, int start, int end){
        int[] arr = Arrays.copyOfRange(nums, start, end + 1);
        if (arr.length <= 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - arr[i-1]!=diff) return false;
        }
        return true;
    }
}
