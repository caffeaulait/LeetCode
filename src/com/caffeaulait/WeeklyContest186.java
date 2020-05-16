package com.caffeaulait;

import java.util.*;

public class WeeklyContest186 {
    /**
     *  q1 pass
     *  q2 fail
     *  q3 fail
     *  q4 fail
     */

    public int maxScore(String s) {
        int max = 0;
        for (int i = 1; i <= s.length()-1;i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            max = Math.max(calcZero(s1) + calcOne(s2), max);
        }
        return max;
    }

    public int calcZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        return count;
    }

    public int calcOne(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    Map<Pair, Integer> map = new HashMap<>();
    public int maxScore(int[] cardPoints, int k) {
        return score(cardPoints,k,0,cardPoints.length-1);
    }

    private int score(int[] cardPoints, int k, int start, int end){
        if (k == 1) return Math.max(cardPoints[start], cardPoints[end]);
        Pair pair = new Pair(start, end);
        for (Pair p : map.keySet()) if (p.equals(pair)) return map.get(p);
        int getFst = score(cardPoints, k - 1, start+1,end) + cardPoints[start];
        int getLst = score(cardPoints, k - 1, start, end - 1) + cardPoints[end];
        int max = Math.max(getFst,getLst);
        map.put(pair, max);
        return max;
    }

    class Pair {
        int first;
        int second;
        public Pair(int f, int s){
            first = f;
            second = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first &&
                    second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        int lstSize = nums.get(nums.size()-1).size();
        for (int i = 0; i < nums.size(); i++){
            for (int j = i; j >=0; j--){
                if (nums.get(j).size()>(i-j)){
                    list.add(nums.get(j).get(i-j));
                }
            }
        }
        for (int m = 1; m < lstSize; m++){
            for (int n = m; n>=0;n--) {
                if (nums.get(lstSize-n).size()>n) {
                    list.add(nums.get(lstSize-n).get(n));
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
