package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0849_MaximizeDistanceToClosetPerson {
    /**
     * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
     *
     * There is at least one empty seat, and at least one person sitting.
     *
     * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
     *
     * Return that maximum distance to the closest person.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: seats = [1,0,0,0,1,0,1]
     * Output: 2
     * Explanation:
     * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
     * If Alex sits in any other open seat, the closest person has distance 1.
     * Thus, the maximum distance to the closest person is 2.
     * Example 2:
     *
     * Input: seats = [1,0,0,0]
     * Output: 3
     * Explanation:
     * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
     * This is the maximum distance possible, so the answer is 3.
     * Example 3:
     *
     * Input: seats = [0,1]
     * Output: 1
     */

    public int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++){
            if (seats[i] == 1) list.add(i);
        }
        int begin = list.get(0);
        int end = seats.length - list.get(list.size()-1) - 1;
        int max = Math.max(begin, end);
        for (int i = 0; i < list.size() - 1; i++){
            int diff = list.get(i + 1) - list.get(i);
            diff /= 2;
            max = Math.max(max, diff);
        }
        return max;
    }
}
