package com.caffeaulait;

import java.util.*;

public class WeeklyContest202 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length-2; i++){
            if (arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1) return true;
        }
        return false;
    }

    public int minOperations(int n) {
        int cost = 0;
        int mid = 0;
        if (n % 2 == 1) {
            mid = 2 * (n / 2) + 1;
            for (int i = 0; i <= n / 2 - 1; i++){
                cost += (mid - (2 * i + 1));
            }
        }else {
            mid =( (2 * (n/2 - 1) + 1) + (2 * (n/2)+1) )/2;
            for (int i = 0; i <= n / 2 - 1; i++){
                cost += (mid - (2 * i + 1));
            }
        }
        return cost;
    }

    public int maxDistance(int[] position, int m) {
        return 0;
    }


    public int minDays(int n) {
        return minDaysHelper(n, new HashMap<>());
    }

    public int minDaysHelper(int n, Map<Integer,Integer> map){
        int res = 1;
        if ( n == 1) return res;
        if (map.containsKey(n)) return map.get(n);
        if (n%2 != 0 && n%3 != 0) {
            res += minDaysHelper(n-1, map);
        } else if (n%2 == 0 && n%3 != 0) {
            res += Math.min(minDaysHelper(n-1, map),
                    minDaysHelper(n/2, map));
        } else if (n%2 !=0 && n% 3 ==0){
            res += Math.min(minDaysHelper(n-1, map), minDaysHelper(n/3, map));
        } else {
            res += Math.min(Math.min(minDaysHelper(n/2, map), minDaysHelper(n/3,
                    map)),
                    minDaysHelper(n -1, map));
        }
        map.put(n, res);
        return res;
    }

    public int minDays2(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            if (i % 2 != 0 && i % 3 != 0) dp[i] = 1 + dp[i-1];
            else if (i % 2 == 0 && i % 3 != 0) dp[i] = Math.min(dp[i-1],
                    dp[i/2])+1;
            else if (i % 2 != 0 && i % 3 == 0 ) dp[i] = Math.min(dp[i-1],
                    dp[i/3])+1;
            else dp[i] = Math.min(Math.min(dp[i/2], dp[i/3]),dp[i-1])+1;
        }
        return dp[n];
    }
}
