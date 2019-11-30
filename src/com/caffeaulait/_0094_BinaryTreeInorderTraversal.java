package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0094_BinaryTreeInorderTraversal {
    /**
     * #94
     * Given a binary tree, return the inorder traversal of its nodes' values.

     Example:

     Input: [1,null,2,3]
     1
     \
     2
     /
     3

     Output: [1,3,2]
     Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root,nodes);
        return nodes;
    }

    public void inorder(TreeNode root, List<Integer>nodes){
        if (root == null) return;
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }

}
