package com.caffeaulait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0501_FindModeInBinarySearchTree {
    /**
     * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * For example:
     * Given BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     *
     *
     * return [2].
     *
     * Note: If a tree has more than one mode, you can return them in any order.
     *
     * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
     */
    int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root, map);
        for (int val : map.keySet()) {
            if (map.get(val) == max) list.add(val);
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    private void dfs(TreeNode root, Map<Integer,Integer> map){
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        max = Math.max(max, map.get(root.val));
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
