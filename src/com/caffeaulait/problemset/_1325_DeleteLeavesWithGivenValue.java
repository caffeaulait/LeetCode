package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _1325_DeleteLeavesWithGivenValue {
    /**
     * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
     *
     * Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left!=null) root.left = removeLeafNodes(root.left, target);
        if (root.right!=null) root.right = removeLeafNodes(root.right, target);
        return root.left == root.right && root.val == target ? null : root;
    }
}
