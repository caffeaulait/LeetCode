package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class nowcoder_38 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        int layer = 1;
        //存放奇数节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        //存放偶数节点
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            if (layer % 2 == 1){
                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if (node != null){
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            }else{
                while (!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    if (node != null){
                        list.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            if (!list.isEmpty()){
                result.add(list);
                layer++;
            }
        }
        return result;
    }
}
