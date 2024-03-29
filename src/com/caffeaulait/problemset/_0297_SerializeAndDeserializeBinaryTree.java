package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0297_SerializeAndDeserializeBinaryTree {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * Example:
     *
     * You may serialize the following tree:
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * as "[1,2,3,null,null,4,5]"
     * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     *
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     */

    private static final String SPLITER = ",";
    private static final String NIL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append(NIL).append(SPLITER);
        }else{
            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes){
        String val = nodes.poll();
        if (val.equals(NIL)) {
            return null;
        } else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
