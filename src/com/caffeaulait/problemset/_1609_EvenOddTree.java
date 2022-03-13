package com.caffeaulait.problemset;


import com.caffeaulait.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _1609_EvenOddTree {
    /**
     * A binary tree is named Even-Odd if it meets the following conditions:
     *
     * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
     * For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
     * For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
     * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return false;
        queue.offer(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            int prev = layer % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (layer % 2 == 0) {
                    if (node.val % 2 == 0 || prev >= node.val) return false;
                }else{
                    if (node.val % 2 == 1 || prev <= node.val) return false;
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                prev = node.val;
            }
            layer++;
        }
        return true;
    }
}
