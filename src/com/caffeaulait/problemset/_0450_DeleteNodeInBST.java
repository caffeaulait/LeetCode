package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

public class _0450_DeleteNodeInBST {
    /**
     * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
     *
     * Basically, the deletion can be divided into two stages:
     *
     * Search for a node to remove.
     * If the node is found, delete the node.
     * Note: Time complexity should be O(height of tree).
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null && curr.val!=key) {
            prev = curr;
            if (curr.val > key) {
                curr = curr.left;
            }else if (curr.val < key) {
                curr = curr.right;
            }
        }
        if (prev == null) return deleteRootNode(root);
        if (prev.left == curr) prev.left = deleteRootNode(curr);
        if (prev.right == curr) prev.right = deleteRootNode(curr);
        return root;
    }

    private TreeNode deleteRootNode(TreeNode root){
        if (root==null) return null;
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode next = root.right;
        TreeNode prev = null;
        //find the minimum value node of right subtree
        while (next.left!=null) {
            prev = next;
            next = next.left;
        }
        next.left = root.left;
        if (root.right != next) {
            prev.left = next.right;
            next.right = root.right;
        }
        return next;
    }
}
