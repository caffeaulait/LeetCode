package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.Stack;

public class _0538_ConvertBSTToGreaterTree {
    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     *
     * Example:
     *
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        while (!stack.isEmpty() || curr!=null){
            while (curr!=null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}
