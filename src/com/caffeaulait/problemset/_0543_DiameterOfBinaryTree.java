package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0543_DiameterOfBinaryTree {
    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.
     */
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode node){
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
