package com.caffeaulait.contest.biweekly;

import java.util.HashMap;
import java.util.Map;

public class BiWeeklyContest31 {
    /**
     * q1   pass
     * q2   fail
     * q3   pass
     * q4   fail
     */
    public int countOdds(int low, int high) {
        if (low % 2 ==0 && high % 2 ==0){
            return (high - low)/2;
        }else if (low % 2 == 1 && high % 2 == 1){
            return (high - low)/2+1;
        }else {
            return (high-1-low)/2+1;
        }
    }

    public int numOfSubarrays(int[] arr) {
        int[] count = new int[]{0,0};
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = (sum + arr[i]) % 2;
            count[sum]++;
        }
        double res = count[1] + count[1] * count[0];
        return (int) (res % (Math.pow(10,9)+7));
    }

    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        int res = 0;
        if (s.length() <= 1) return 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length()-1;i++){
            char c = s.charAt(i);
            left.put(c, left.getOrDefault(c,0)+1);
            if (right.get(c) == 1) {
                right.remove(c);
            }else{
                right.put(c, right.getOrDefault(c, 0)-1);
            }
            if (left.size() == right.size()) res++;
        }
        return res;
    }
}
