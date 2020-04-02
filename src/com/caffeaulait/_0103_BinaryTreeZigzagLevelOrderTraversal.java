package com.caffeaulait;

import java.util.*;

public class _0103_BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its zigzag level order traversal as:
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        if (root == null) return result;
        queue.offer(root);
        boolean odd = true;
        while (!queue.isEmpty()){
            list = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                if (odd){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            result.add(list);
            odd = !odd;
        }
        return result;
    }

}