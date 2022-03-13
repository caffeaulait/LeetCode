package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0513_FindBottomLeftTreeValue {
    /**
     * Given a binary tree, find the leftmost value in the last row of the tree.
     *
     * Example 1:
     * Input:
     *
     *     2
     *    / \
     *   1   3
     *
     * Output:
     * 1
     * Example 2:
     * Input:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * Output:
     * 7
     * Note: You may assume the tree (i.e., the given root node) is not NULL.
     */
    int maxHeight = 0;
    int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return value;
    }

    private void dfs(TreeNode root, int height){
        if (root == null) return;
        if (height > maxHeight) {
            maxHeight = height;
            value = root.val;
        }
        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }


}
