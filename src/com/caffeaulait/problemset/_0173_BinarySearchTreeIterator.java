package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.Stack;

public class _0173_BinarySearchTreeIterator {
    /**
     * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
     *
     * Calling next() will return the next smallest number in the BST.
     *
     *
     *
     * Example:
     *
     *
     *
     * BSTIterator iterator = new BSTIterator(root);
     * iterator.next();    // return 3
     * iterator.next();    // return 7
     * iterator.hasNext(); // return true
     * iterator.next();    // return 9
     * iterator.hasNext(); // return true
     * iterator.next();    // return 15
     * iterator.hasNext(); // return true
     * iterator.next();    // return 20
     * iterator.hasNext(); // return false
     */
//    List<Integer> values = new ArrayList<>();
//
//    public _0173_BinarySearchTreeIterator(TreeNode root) {
//        toList(root);
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return values.remove(0);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return (values.size()>0);
//    }
//
//    public void toList(TreeNode root){
//        if (root==null) return;
//        toList(root.left);
//        values.add(root.val);
//        toList(root.right);
//    }

    private Stack<TreeNode> stack;
    public _0173_BinarySearchTreeIterator(TreeNode root){
        stack = new Stack<>();
        TreeNode curr = root;
        while ( curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        if (curr.right!=null){
            curr = curr.right;
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        return node.val;
    }

}
