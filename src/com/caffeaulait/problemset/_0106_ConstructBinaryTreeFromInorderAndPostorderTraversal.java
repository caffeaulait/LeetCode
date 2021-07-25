package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.Arrays;

public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length<=0) return null;
        int value = postorder[postorder.length-1];
        int index = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == value){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = buildTree(Arrays.copyOfRange(inorder,0,index), Arrays.copyOfRange(postorder,0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length), Arrays.copyOfRange(postorder,index, postorder.length-1));
        return root;
    }
}

