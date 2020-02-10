package com.caffeaulait;

import java.util.Stack;

public class nowcoder_41 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     */
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int i = 0;
        do{
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            i++;
            if (i == k) return curr;
            curr = curr.right;
        }while (curr !=null || !stack.isEmpty());
        return null;
    }
}
