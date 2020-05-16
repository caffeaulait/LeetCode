package com.caffeaulait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiWeeklyContest25 {
    /**
     * q1   pass
     * q2   fail
     * q3   pass
     * q4   fail
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++){
            boolean flag = true;
            candies[i]+=extraCandies;
            for (int j = 0; j<candies.length; j++){
                if (candies[i] < candies[j]) flag = false;
            }
            result.add(flag);
            candies[i]-=extraCandies;
        }
        return result;
    }


    public static int maxDiff(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int firstDigit = nums[0];
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == firstDigit) {
                nums[i] = '9';
            }
        }
        int a = Integer.parseInt(String.valueOf(nums));
//        System.out.println(a);
        firstDigit = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == firstDigit) {
                nums[i] = '1';
            }
        }
        int b = Integer.parseInt(String.valueOf(nums));
//        System.out.println(b);
        return a - b;
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (canBreak(chars1, chars2) || canBreak(chars2,chars1)) return true;
        return false;
    }


    private boolean canBreak(char[] s1, char[] s2){
        //s1 can break s2 s1[i]>=s2[i];
        for (int i = 0; i < s1.length; i++){
            if (s1[i] < s2[i]) return false;
        }
        return true;
    }
}
