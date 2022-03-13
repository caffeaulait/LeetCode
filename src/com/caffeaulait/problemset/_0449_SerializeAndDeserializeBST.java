package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0449_SerializeAndDeserializeBST {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * The encoded string should be as compact as possible.
     *
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                sb.append("#,");
            }
        }
        if (sb.length()!=0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0) return null;
        String[] strs = data.split(",");
        TreeNode[] nodes = new TreeNode[strs.length];
        for (int i = 0; i < nodes.length;i++){
            if (!strs[i].equals("#")) nodes[i] = new TreeNode(Integer.valueOf(strs[i]));
        }
        for (int i = 0, j = 1; j < nodes.length; i++){
            if (nodes[i]!=null){
                nodes[i].left = nodes[j++];
                nodes[i].right = nodes[j++];
            }
        }
        return nodes[0];
    }
}
