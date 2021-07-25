package com.caffeaulait.contest.weekly;

public class WeeklyContest219 {
    /**
     *
     */
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                res += n;
            }else {
                n = n / 2;
                res += n;
                n++;
            }
        }
        return res;
    }

    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            int curr = Integer.parseInt(String.valueOf(c));
            max = Math.max(curr, max);
        }
        return max;
    }
}
