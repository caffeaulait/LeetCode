package com.caffeaulait;

public class _1008_ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * Return the root node of a binary search tree that matches the given preorder traversal.
     *
     * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
     *
     *
     *
     * Example 1:
     *
     * Input: [8,5,1,7,10,12]
     * Output: [8,5,10,1,7,null,12]
     *
     *
     *
     * Note:
     *
     * 1 <= preorder.length <= 100
     * The values of preorder are distinct.
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length);
    }

    private TreeNode bst(int[] preorder, int start, int end){
        if (start >= end) return null;
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int i = start + 1;
        for (; i < preorder.length;i++){
            if (preorder[i] > rootVal) break;
        }
        root.left = bst(preorder, start+1, i);
        root.right = bst(preorder, i, end);
        return root;
    }
}
