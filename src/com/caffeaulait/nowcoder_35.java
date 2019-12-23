package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class nowcoder_35 {
    /**
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     */

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        find(root,target,list,result);
        return result;
    }

    public void find(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if (root == null) return;
        int value = root.val;
        list.add(value);
        if (target == value && root.left ==null && root.right == null){
            result.add(new ArrayList<>(list));
        }else{
            find(root.left,target-value,list,result);
            find(root.right,target-value,list,result);
        }
        list.remove(list.size()-1);
    }
}
