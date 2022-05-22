package com.caffeaulait.contest.weekly;

import java.util.Arrays;
import java.util.Comparator;

public class WeeklyContest294 {

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] arr = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            arr[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        for(;i < arr.length; i++) {
            if(arr[i] == 0) count++;
            else break;
        }
        for(; i < arr.length; i++) {
            if(additionalRocks <= 0 || additionalRocks < arr[i]) {
                break;
            }
            additionalRocks -= arr[i];
            count++;
        }
        return count;
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length < 2) {
            return 0;
        }
        if(stockPrices.length == 2) {
            return 1;
        }
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int[] prev = stockPrices[0];
        int[] curr = stockPrices[1];
        double slope = calcSlope(curr, prev);
        prev = curr;
        int count = 1;
        for(int i = 2; i < stockPrices.length; i++) {
            curr = stockPrices[i];
            if (calcSlope(curr, prev) != slope) {
                count++;
                slope = calcSlope(curr, prev);
            }
            prev = curr;
        }
        return count;
    }

    public double calcSlope(int[] curr, int[] prev) {
        return (curr[1] - prev[1])*1.0 / (curr[0]-prev[0]);
    }

    public int totalStrength(int[] strength) {
        long sum = 0;
        for(int i = 0; i < strength.length; i++) {
            int subSum = 0;
            int subMin = strength[i];
            for(int j = i; j < strength.length; j++) {
                subSum += strength[j];
                subMin = Math.min(subMin, strength[j]);
                sum += subSum * subMin;
            }
        }
        return (int) (sum % 1000000007);
    }
}
