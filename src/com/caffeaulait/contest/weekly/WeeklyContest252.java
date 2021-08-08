package com.caffeaulait.contest.weekly;

public class WeeklyContest252 {

    public boolean isThree(int n) {
        int count = 0;
        for (int i = 1; i <=n; i++) {
            if (n % i == 0) count++;
        }
        return count == 3;
    }

    public long numberOfWeeks(int[] milestones) {
        return 0;
    }
}
