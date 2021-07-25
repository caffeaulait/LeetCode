package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0993_CousinsInBinaryTree {
    /**
     *  In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     *
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     *
     * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
     *
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,4], x = 4, y = 3
     * Output: false
     * Example 2:
     *
     *
     * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
     * Output: true
     * Example 3:
     *
     *
     *
     * Input: root = [1,2,3,null,4], x = 2, y = 3
     * Output: false
     *
     *
     * Note:
     *
     * The number of nodes in the tree will be between 2 and 100.
     * Each node has a unique integer value from 1 to 100.
     *
     */

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundX = false;
        boolean foundY = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            foundX = false;
            foundY = false;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;
                if(node.left!=null&&node.right!=null){
                    if((node.left.val==x&&node.right.val==y)||(node.left.val==y&&node.right.val==x)) return false;
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            if (foundX && foundY) return true;
        }
        return false;
    }
}
