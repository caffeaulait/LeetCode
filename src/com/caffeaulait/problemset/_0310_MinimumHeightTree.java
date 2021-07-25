package com.caffeaulait.problemset;

import java.util.*;

public class _0310_MinimumHeightTree {
    /**
     * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
     *
     * Format
     * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
     *
     * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     *
     * Example 1 :
     *
     * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     *
     *         0
     *         |
     *         1
     *        / \
     *       2   3
     *
     * Output: [1]
     * Example 2 :
     *
     * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     *
     *      0  1  2
     *       \ | /
     *         3
     *         |
     *         4
     *         |
     *         5
     *
     * Output: [3, 4]
     */

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        //index of list is the vertex number, corresponding set item are connected vertices.
        for (int [] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++){
            //only connected to one node
            if (adj.get(i).size()==1) leaves.add(i);
        }
        while ( n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                int parent = adj.get(leave).iterator().next();
                adj.get(parent).remove(leave);
                if (adj.get(parent).size() == 1) newLeaves.add(parent);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
