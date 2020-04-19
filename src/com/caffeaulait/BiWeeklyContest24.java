package com.caffeaulait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiWeeklyContest24 {
    /**
     * q1 pass
     * q2 pass
     * q3 pass
     * q3 unsolved
     */
    public int minStartValue(int[] nums) {
        int min = 0;
        int acc = 0;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            min = Math.min(min, acc);
        }
        return 1-min;
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = findFib(k);
        int index = list.size() - 1;
        int count = 0;
        while (k > 0) {
            count += (k / list.get(index));
            k %= list.get(index);
            index--;
        }
        return count;
    }

    private List<Integer> findFib(int k){
        // Find all Fibonacci Terms less than or equal to K.
        List<Integer> list = new ArrayList<>();
        if (k<=0) return list;
        int a = 1, b = 1;
        while (b<=k){
            list.add(b);
            b = a + b;
            a = b - a;
        }
        return list;
    }

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        getStrings(n, list, new StringBuilder());
        Collections.sort(list);
        if (list.size() < k) return "";
        return list.get(k-1);
    }

    private void getStrings(int n, List<String> list, StringBuilder sb){
        char[] ch = {'a', 'b', 'c'};
        if (sb.length() == n) {
            list.add(new String(sb));
        }else{
            for (char c : ch) {
                if (sb.length()!=0 && sb.charAt(sb.length()-1) == c) continue;
                sb.append(c);
                getStrings(n, list, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public int numberOfArrays(String s, int k) {
        return 0;
    }
}
