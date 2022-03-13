package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0101_SymmetricTree {
    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * But the following [1,2,2,null,3,null,3] is not:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode t1, TreeNode t2){
        if (t1 == null) return t2==null;
        if (t2 == null) return false;
        return (t1.val == t2.val) && mirror(t1.left,t2.right) && mirror(t1.right,t2.left);
    }
}
