package com.caffeaulait.contest.weekly;

public class WeeklyContest199 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */
    public String restoreString(String s, int[] indices) {
        char[] res= new char[s.length()];
        for (int i = 0; i < s.length(); i++){
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }

}
