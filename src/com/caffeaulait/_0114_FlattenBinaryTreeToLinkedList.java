package com.caffeaulait;

import java.util.Stack;

public class _0114_FlattenBinaryTreeToLinkedList {
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */

    public void flatten(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
            if (!stack.isEmpty())
                node.right = stack.peek();
            node.left = null;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten2(left);
        flatten2(right);

        root.right = left;
        TreeNode curr = root;
        while (curr.right!=null) curr = curr.right;
        curr.right = right;
    }



}
