package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;
import java.util.*;

public class _2385_AmountOfTimeForBinaryTreeToBeInfected {
    /**
     * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
     *
     * Each minute, a node becomes infected if:
     *
     * The node is currently uninfected.
     * The node is adjacent to an infected node.
     * Return the number of minutes needed for the entire tree to be infected.
     */


    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int num : map.get(curr)) {
                    if (!visited.contains(num)) {
                        q.add(num);
                        visited.add(num);
                    }
                }
            }
            min++;
        }
        return min - 1;
    }

    public void convert(TreeNode root, int parent, Map<Integer, Set<Integer>> map) {
        if (root == null) return;
        Set<Integer> set = new HashSet<>();
        if (parent != 0) set.add(parent);
        if (root.left != null) set.add(root.left.val);
        if (root.right != null) set.add(root.right.val);
        map.put(root.val, set);
        convert(root.left, root.val, map);
        convert(root.right, root.val, map);
    }
}
