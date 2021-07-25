package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102_BinaryTreeLevelOrderTraversal {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list;
        while (!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
