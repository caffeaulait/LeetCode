package com.caffeaulait.contest.biweekly;

import java.util.PriorityQueue;
import java.util.Queue;

public class BiWeeklyContest51 {
    /**
     *
     */

    public String replaceDigits(String s) {
        char[] result = s.toCharArray();
        int len = result.length;
        if (len % 2 == 1) {
            len--;
        }
        for (int i = 0; i < len; i+=2) {
            char ch = result[i];
            int digit = Integer.parseInt(String.valueOf(result[i+1]));
            result[i+1] = (char) (ch + digit);
        }
        return String.valueOf(result);
    }

    class SeatManager {

        private Queue<Integer> queue;

        private int size;

        public SeatManager(int n) {
            queue = new PriorityQueue<>();
            for (int i = 1; i <=n; i++) queue.offer(i);
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.offer(seatNumber);
        }
    }
}
