package com.caffeaulait.nowcoder;

import com.caffeaulait.miscellaneous.TreeNode;

public class nowcoder_30 {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        else{
            return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 &&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        }
    }

    public int getHeight(TreeNode root){
        if (root == null)
            return 0;
        else
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
