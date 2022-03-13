package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144_BinaryTreePreOrderTraversal {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
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
     * Output: [1,2,3]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preTravrse(root,result);
        return result;
    }

    public void preTravrse(TreeNode root, List<Integer> res){
        if (root!=null){
            res.add(root.val);
            preTravrse(root.left,res);
            preTravrse(root.right,res);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null) return result;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
        }
        return result;
    }
}
