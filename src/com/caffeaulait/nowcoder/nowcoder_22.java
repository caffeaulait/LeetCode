package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class nowcoder_22 {
    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
            list.add(node.val);
        }
        return list;
    }
}
