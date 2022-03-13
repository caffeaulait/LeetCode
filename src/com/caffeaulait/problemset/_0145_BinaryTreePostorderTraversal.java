package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0145_BinaryTreePostorderTraversal {
    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [3,2,1]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */


    //https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45621/Preorder-Inorder-and-Postorder-Traversal-Iterative-Java-Solution

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postOrder(root,list);
        return list;
    }

    public void postOrder(TreeNode root, List<Integer> list){
        if (root==null) return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null) return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);
        }
        return list;
    }
}
