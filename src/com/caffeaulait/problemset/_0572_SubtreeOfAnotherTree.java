package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0572_SubtreeOfAnotherTree {
    /**
     * Given two non-empty binary trees s and t, check whether tree t has exactly
     * the same structure and node values with a subtree of s. A subtree of s is a
     * tree consists of a node in s and all of this node's descendants. The tree s
     * could also be considered as a subtree of itself.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return  (s.val ==t.val) && sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}
