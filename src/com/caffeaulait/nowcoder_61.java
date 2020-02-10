package com.caffeaulait;

import java.util.LinkedList;
import java.util.Queue;

public class nowcoder_61 {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     *
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
     * 以 ！ 表示一个结点值的结束（value!）。
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     */

    //层序遍历
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node !=null){
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val+",");
            }else{
                sb.append("#" +",");
            }
        }
        if (sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        TreeNode head = null;
        if (str == null || str.length() == 0){
            return head;
        }
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i =0;i<nodes.length;i++){
            if (!nodes[i].equals("#")){
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
            }
        }
        for (int i =0,j=1;j<treeNodes.length;i++){
            if (treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }
}
