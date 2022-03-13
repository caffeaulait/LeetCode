package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0508_MostFrequentSubtreeSum {
    /**
     * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
     *
     * Examples 1
     * Input:
     *
     *   5
     *  /  \
     * 2   -3
     * return [2, -3, 4], since all the values happen only once, return all of them in any order.
     * Examples 2
     * Input:
     *
     *   5
     *  /  \
     * 2   -5
     * return [2], since 2 happens twice, however -5 only occur once.
     * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
     */
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int s : map.keySet()) {
            if (map.get(s) == max) list.add(s);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int s = dfs(root.left) + dfs(root.right) + root.val;
        map.put(s, map.getOrDefault(s, 0)+1);
        max = Math.max(max, map.get(s));
        return s;
    }

}
