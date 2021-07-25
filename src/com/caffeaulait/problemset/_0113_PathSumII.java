package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _0113_PathSumII {
    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \    / \
     * 7    2  5   1
     * Return:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> result= new LinkedList<>();
        backTrack(root, sum, list, result);
        return result;
    }


    private void backTrack(TreeNode node,  int sum, List<Integer> list, List<List<Integer>> result){
        if (node==null) return;
        list.add(node.val);
        if (node.left==null && node.right==null && node.val == sum) {
            result.add(new LinkedList<>(list));
        }else{
            backTrack(node.left, sum-node.val, list, result);
            backTrack(node.right, sum-node.val, list, result);
        }
        list.remove(list.size()-1);
    }
}
