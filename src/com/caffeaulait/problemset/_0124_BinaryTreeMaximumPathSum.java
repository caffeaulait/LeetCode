package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0124_BinaryTreeMaximumPathSum {
    /**
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     */
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPath(root);
        return maxValue;
    }

    private int maxPath(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
