package com.caffeaulait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class nowcoder_39 {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        int start = 0, end = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            start++;
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
            if (start == end){
                result.add(list);
                list = new ArrayList<>();
                start = 0;
                end = queue.size();
            }
        }
        return result;
    }
}
