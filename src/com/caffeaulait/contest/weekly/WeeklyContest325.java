package com.caffeaulait.contest.weekly;

import java.util.Objects;

public class WeeklyContest325 {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (Objects.equals(words[startIndex], target)) return 0;
        int rightStep = 0;
        int leftStep = 0;
        int i = startIndex+1;
        for (;;) {
            if (i >= words.length) {
                i = 0;
            }
            if (i == startIndex) {
                return -1;
            }
            rightStep++;
            if (Objects.equals(words[i], target)) {
                break;
            }
            i++;
        }
        i = startIndex - 1;
        for (;;) {
            if (i < 0) {
                i = words.length-1;
            }
            if (i == startIndex) {
                return -1;
            }
            leftStep++;
            if (Objects.equals(words[i], target)) {
                break;
            }
            i--;
        }
        return Math.min(leftStep, rightStep);
    }
}
