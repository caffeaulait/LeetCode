package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.Arrays;

public class _0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    /**
     * Return any binary tree that matches the given preorder and postorder traversals.
     *
     * Values in the traversals pre and post are distinct positive integers.
     *
     *
     *
     * Example 1:
     *
     * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
     * Output: [1,2,3,4,5,6,7]
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        int rootValue = pre[0];
        TreeNode root = new TreeNode(rootValue);
        if (pre.length < 2) return root;
        int leftRootValue = pre[1];
        int idx = 0;
        for (int i = 0; i < post.length; i++){
            if (post[i] == leftRootValue) {
                idx = i;
                break;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 2+idx),
                Arrays.copyOfRange(post, 0, idx+1) );
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, idx+2,
                pre.length),Arrays.copyOfRange(post, idx+1, post.length-1));
        return root;
    }
}
