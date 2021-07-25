package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0886_PossibleBipartition {
    /**
     * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
     *
     * Each person may dislike some other people, and they should not go into the same group.
     *
     * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
     *
     * Return true if and only if it is possible to split everyone into two groups in this way.
     *
     *
     *
     * Example 1:
     *
     * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
     * Output: true
     * Explanation: group1 [1,4], group2 [2,3]
     * Example 2:
     *
     * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
     * Output: false
     * Example 3:
     *
     * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
     * Output: false
     *
     */
    List<Integer>[] disList;
    int[] color;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        disList = new List[N+1];
        for (int i = 1; i <= N; i++){
            disList[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes){
            disList[edge[0]].add(edge[1]);
            disList[edge[1]].add(edge[0]);
        }
        color = new int[N+1];
        for (int person = 1; person <= N; person++){
            if (color[person] == 0 && !dfs(person, 1))
                return false;
        }
        return true;
    }

    private boolean dfs(int person, int color){
        if (this.color[person] == 0){
            this.color[person] = color;
            int childColor = color == 1 ? -1 : 1;
            for ( int child : disList[person] ){
                if ( !dfs(child, childColor) )
                    return false;
            }
        }else{
            if ( this.color[person] != color)
                return false;
        }
        return true;
    }
}
