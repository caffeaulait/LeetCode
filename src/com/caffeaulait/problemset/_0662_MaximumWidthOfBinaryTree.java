package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0662_MaximumWidthOfBinaryTree {
    /**
     * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the
     * maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
     *
     * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes
     * in the level, where the null nodes between the end-nodes are also counted into the length calculation.
     *
     * Example 1:
     *
     * Input:
     *
     *            1
     *          /   \
     *         3     2
     *        / \     \
     *       5   3     9
     *
     * Output: 4
     * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
     * Example 2:
     *
     * Input:
     *
     *           1
     *          /
     *         3
     *        / \
     *       5   3
     *
     * Output: 2
     * Explanation: The maximum width existing in the third level with the length 2 (5,3).
     */

    /**
     * The idea is to traverse all the node in the tree in level order(Here I use one Queue to store each level's nodes.
     * The time I traverse each level is the queue's size(the number of nodes from upper level)). Each time a node is
     * traversed, the position of the node(as it is in a full binary tree) is stored in the HashMap. If the position of
     * the parent node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'. The width of each level
     * is the last node's position in this level subtracts the first node's position in this level plus 1.
     */
    public int widthOfBinaryTree(TreeNode root){
        if (root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root,1);
        int width = 0;
        int maxWidth = 0;
        while (!queue.isEmpty()){
            //size 每一层节点的数量
            int size = queue.size();
            //start end 每一层第一个节点和最后一个节点的index
            int start = 0, end = 0;
            for (int i = 0 ; i < size;i++){
                TreeNode node = queue.poll();
                if (i==0) start = map.get(node);
                if (i==size-1) end = map.get(node);
                if (node.left!=null){
                    map.put(node.left,map.get(node)*2);
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    map.put(node.right,map.get(node)*2+1);
                    queue.offer(node.right);
                }
            }
            width = end - start + 1;
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}
