package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0429_NaryTreeLevelOrderTraversal {
    /**
     * Given an n-ary tree, return the level order traversal of its nodes' values.
     */

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        List<Integer> list;
        while (!queue.isEmpty()){
            size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    if (child!=null) queue.offer(child);
                }
            }
            result.add(list);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
