package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.TreeNode;

import java.util.Stack;

public class nowcoder_36 {
    /**
     *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        boolean isFirst = true;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (isFirst){
                root = curr;
                isFirst =false;
            }else{
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            curr = curr.right;
        }
        return root;

    }
}
