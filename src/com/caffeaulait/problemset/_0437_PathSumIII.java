package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

public class _0437_PathSumIII {
    /**
     * You are given a binary tree in which each node contains an integer value.
     *
     * Find the number of paths that sum to a given value.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     *
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     *
     * Example:
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Return 3. The paths that sum to 8 are:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return findPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    public int findPath(TreeNode root, int sum){
        int res = 0;
        if (root==null) return res;
        if (sum == root.val) res++;
        res += findPath(root.left, sum-root.val);
        res += findPath(root.right, sum-root.val);
        return res;
    }
}
