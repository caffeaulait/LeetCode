package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0590_NaryTreePostorderTraversal {
    /**
     * Given an n-ary tree, return the postorder traversal of its nodes' values.
     *
     * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     *
     *
     *
     * Follow up:
     *
     * Recursive solution is trivial, could you do it iteratively?
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: root = [1,null,3,2,4,null,5,6]
     * Output: [5,6,3,2,4,1]
     * Example 2:
     *
     *
     *
     * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
     */

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    private void traverse(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node child : root.children) {
            traverse(child, list);
        }
        list.add(root.val);
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
