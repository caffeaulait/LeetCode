package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest210 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */

    public int maxDepth(String s) {
        if (s.isEmpty()) return 0;
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }else if (c == ')') {
                stack.pop();
            }
            depth = Math.max(depth, stack.size());
        }
        return depth;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int max = 0;
        int curr = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                curr = map.get(i).size() + map.get(j).size();
                if (map.get(i).contains(j)) curr--;
                max = Math.max(curr, max);
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int i, int j) {
        for (;i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }
    public boolean check(String a, String b) {
        int i = 0, j = a.length()-1;
        while ( i < j) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j--;
            }else{
                return isPalindrome(a, i, j) || isPalindrome(b, i, j);
            }
        }
        return true;
    }
}
