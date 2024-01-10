package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0872_LeafSimilarTrees {
    /**
     *Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
     *
     *
     *
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
     *
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     *
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2 == null;
        if (root2 == null) return false;
        String s1 = traverse(root1);
        String s2 = traverse(root2);
        return s1.equals(s2);
    }

    public String traverse(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "-";
        return traverse(root.left) + traverse(root.right);
    }
}
