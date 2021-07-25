package com.caffeaulait.contest.biweekly;

import java.util.*;

public class BiWeeklyContest42 {
    /**
     * q1
     * q2
     * q3
     * q4
     */

    public int countStudents(int[] students, int[] sandwiches) {
        List<Integer> list = new LinkedList<>(toList(students));
        List<Integer> food = new LinkedList<>(toList(sandwiches));
        while (list.size() > 0) {
            if (!list.get(0).equals(food.get(0))) {
                if (isSame(list)) {
                    break;
                }else {
                    int el = list.remove(0);
                    list.add(el);
                }
            }else {
                list.remove(0);
                food.remove(0);
            }
        }
        return list.size();
    }

    private List<Integer> toList(int[] students) {
        List<Integer> list = new ArrayList<>();
        for (int el : students) list.add(el);
        return list;
    }

    private boolean isSame(List<Integer> list) {
        if (list.size() == 0) return true;
        int el = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (el != list.get(i)) return false;
        }
        return true;
    }

    public double averageWaitingTime(int[][] customers) {
        int count = customers.length;
        double waitTime = 0;
        int total = customers[0][0];
        for (int[] customer : customers) {
            if (total >= customer[0]) {
                total += customer[1];
            }else {
                total = customer[0] + customer[1];
            }
            waitTime += (total - customer[0]);
        }
        return waitTime / (count * 1.0);
    }

    public String maximumBinaryString(String binary) {
        return null;
    }
}
