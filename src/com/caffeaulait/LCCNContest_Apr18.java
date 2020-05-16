package com.caffeaulait;

import java.util.*;

public class LCCNContest_Apr18 {
    /**
     * q1 pass
     * q2 pass
     * q3 fail
     * q4 fail
     * q5 fail
     */
    public int minCount(int[] coins) {
        int count = 0;
        for(int coin : coins) {
            count += Math.ceil(coin / 2.0);
        }
        return count;
    }

    private Map<Pair, Integer> map = new HashMap<>();

    public int numWays(int n, int[][] relation, int k) {
        return way(n, relation, k, 0);
    }

    private int way(int n, int[][] relation, int k, int curr){
        Pair p = new Pair(curr, k);
        if (map.containsKey(p)) return map.get(p);
        int count = 0;
        if (k == 0) {
            if (curr == n - 1) count = 1;
        }
        else {
            for (int[] rel : relation) {
                if (rel[0] == curr) {
                    count += way(n, relation, k - 1, rel[1]);
                }
            }
        }
        map.put(p, count);
        return count;
    }

    class Pair {
        int curr;
        int k;
        public Pair(int curr, int k){
            this.curr = curr;
            this.k = k;
        }
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] result = new int[requirements.length];
        Arrays.fill(result, -1);
        Triple[] inct = new Triple[increase.length];
        Triple[] reqt = new Triple[requirements.length];
        Triple curr = new Triple(0, 0, 0);
        for (int i = 0; i<increase.length; i++) {
            inct[i] = new Triple(increase[i][0], increase[i][1],increase[i][2]);
        }
        for (int i = 0; i<requirements.length; i++){
            reqt[i] = new Triple(requirements[i][0],requirements[i][1],requirements[i][2]);
        }
        for (int j = 0; j < reqt.length; j++){
            if (curr.compareTo(reqt[j]) >=0) result[j] = 0;
        }
        for (int i = 0; i < inct.length; i++) {
            curr.add(inct[i]);
            for (int j = 0; j < reqt.length; j++){
                if (result[j]==-1 && curr.compareTo(reqt[j]) >= 0) result[j] = i+1;
            }
        }
        return result;
    }

    class Triple{
        int C;
        int R;
        int H;
        public Triple(int C, int R, int H){
            this.C = C;
            this.R = R;
            this.H = H;
        }

        public int compareTo(Triple p) {
            if (C == p.C && R == p.R && H == p.H) return 0;
            else if (C >= p.C && R >= p.R && H >= p.H) return 1;
            else return -1;
        }

        public void add(Triple p){
            this.C += p.C;
            this.R += p.R;
            this.H += p.H;
        }
    }
}
