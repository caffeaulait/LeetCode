package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0617_MergeTwoBinaryTrees {
    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees
     * are overlapped while the others are not.
     *
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values
     * up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        if (t1 == null && t2 == null) {
            return null;
        }
        else if(t1==null){
            root = t2;
        }
        else if(t2==null){
            root = t1;
        }
        else {
            root = new TreeNode(t1.val+t2.val);
            root.left = mergeTrees(t1.left,t2.left);
            root.right = mergeTrees(t1.right,t2.right);
        }
        return root;
    }
}
