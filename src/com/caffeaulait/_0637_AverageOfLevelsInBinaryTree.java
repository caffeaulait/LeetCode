package com.caffeaulait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0637_AverageOfLevelsInBinaryTree {
    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     * Example 1:
     * Input:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * Output: [3, 14.5, 11]
     * Explanation:
     * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return list;
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left!=null) q.offer(curr.left);
                if (curr.right!=null) q.offer(curr.right);
            }
            list.add( sum / (size *1.0));
        }
        return list;
    }
}
