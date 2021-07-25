package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest236 {

    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num > 0) {
                //do nothing
            } else if (num < 0){
                res = -res;
            } else {
                return 0;
            }
        }
        return res;
    }

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    public int minSideJumps(int[] obstacles) {
        return 0;
    }
}
