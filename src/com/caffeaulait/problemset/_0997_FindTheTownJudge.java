package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0997_FindTheTownJudge {
    /**
     * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
     *
     * If the town judge exists, then:
     *
     * The town judge trusts nobody.
     * Everybody (except for the town judge) trusts the town judge.
     * There is exactly one person that satisfies properties 1 and 2.
     * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
     *
     * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
     *
     * Example 1:
     *
     * Input: N = 2, trust = [[1,2]]
     * Output: 2
     * Example 2:
     *
     * Input: N = 3, trust = [[1,3],[2,3]]
     * Output: 3
     * Example 3:
     *
     * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
     * Output: -1
     * Example 4:
     *
     * Input: N = 3, trust = [[1,2],[2,3]]
     * Output: -1
     * Example 5:
     *
     * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * Output: 3
     */

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) return 1;
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for (int[] t : trust) {
            in.put(t[0], in.getOrDefault(t[0],0)+1);
            out.put(t[1], out.getOrDefault(t[1],0)+1);
        }
        int result = -1;
        for (int k : out.keySet()){
            if (out.get(k) == N-1) result = k;
        }
        if (!in.containsKey(result)) return result;
        else return -1;
    }
}
