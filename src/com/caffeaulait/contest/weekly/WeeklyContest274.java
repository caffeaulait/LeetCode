package com.caffeaulait.contest.weekly;

import java.util.Arrays;

public class WeeklyContest274 {

    public boolean checkString(String s) {
        // no a
        int aIndex = s.lastIndexOf('a');
        if (aIndex == -1) {
            return true;
        }
        int bIndex = s.indexOf('b');
        if (bIndex == -1) {
            return true;
        }
        return aIndex < bIndex;
    }

    public int numberOfBeams(String[] bank) {
        int res = 0;
        int[] count = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            count[i] = countOnes(bank[i]);
        }
        for(int i = 0; i < bank.length-1; i++) {
            if (count[i] == 0) continue;
            for (int j = i+1; j < bank.length; j++) {
                if(count[j] > 0) {
                    res += count[i] * count[j];
                    break;
                }
            }
        }
        return res;
    }

    public int countOnes(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') res++;
        }
        return res;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        double planet = mass;
        for (int asteroid : asteroids) {
            if (planet >= asteroid) {
                planet += asteroid;
            } else {
                System.out.printf("the planet is %f, the asteroid is : %d", planet, asteroid);
                return false;
            }
        }
        return true;
    }
}
