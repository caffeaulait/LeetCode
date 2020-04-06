package com.caffeaulait;

public class _0404_SumOfLeftLeaves {
    /**
     *
     Find the sum of all left leaves in a given binary tree.

     Example:

     3
     / \
     9  20
     /  \
     15   7

     There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return sumValue(root, false);
    }

    private int sumValue(TreeNode root, boolean isLeft){
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null) return root.val;
        return sumValue(root.left, true) + sumValue(root.right, false);
    }
}
