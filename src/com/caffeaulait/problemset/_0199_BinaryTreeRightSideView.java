package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0199_BinaryTreeRightSideView {
    /**
     *Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
     *
     * Example:
     *
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                if (i == size - 1) list.add(node.val);
            }
        }
        return list;
    }
}
