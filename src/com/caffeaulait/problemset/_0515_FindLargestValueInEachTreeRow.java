package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0515_FindLargestValueInEachTreeRow {
    /**
     * You need to find the largest value in each row of a binary tree.
     *
     * Example:
     * Input:
     *
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     *
     * Output: [1, 3, 9]
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }
}
