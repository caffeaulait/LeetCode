package com.caffeaulait;

public class _0117_PopulatingNextRightPointersInEachNodeII {
    /**
     *Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     */
    public Node connect(Node root) {
        Node curr = root;       //current parent node
        Node prev = null;       //previous node on the next level
        Node start = null;      //head node on the next level
        while (curr != null) {
            while ( curr != null) {
                if (curr.left != null){
                    if (prev != null) prev.next = curr.left;
                    else start = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null){
                    if (prev != null) prev.next = curr.right;
                    else start = curr.right;
                    prev = curr.right;
                }
                //move to the next node
                curr = curr.next;
            }
            //move to the next level
            curr = start;
            start = null;
            prev = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
