package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.Arrays;

public class _0105_ConstructBinaryTreeFromPreOrderAndInorderTraversal {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length<=0) return null;
        int value = preorder[0];
        int index = 0;
        for (int i = 0;i<inorder.length;i++){
            if (inorder[i] == value){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
}
