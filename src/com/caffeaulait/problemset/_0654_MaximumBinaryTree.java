package com.caffeaulait.problemset;


import com.caffeaulait.struct.TreeNode;

public class _0654_MaximumBinaryTree {
    /**
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
     *
     * The root is the maximum number in the array.
     * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     * Construct the maximum tree by the given array and output the root node of this tree.
     *
     * Example 1:
     * Input: [3,2,1,6,0,5]
     * Output: return the tree root node representing the following tree:
     *
     *       6
     *     /   \
     *    3     5
     *     \    /
     *      2  0
     *        \
     *         1
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if (start >= end) return null;
        int index = start;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end ;i++){
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, start, index);
        root.right = buildTree(nums, index+1, end);
        return root;
    }
}
