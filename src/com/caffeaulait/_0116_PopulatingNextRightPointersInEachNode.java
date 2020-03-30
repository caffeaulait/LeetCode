package com.caffeaulait;

public class _0116_PopulatingNextRightPointersInEachNode {
    /**
     * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * Initially, all next pointers are set to NULL.
     * <p>
     * <p>
     * <p>
     * Follow up:
     * <p>
     * You may only use constant extra space.
     * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * <p>
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [1,#,2,3,#,4,5,6,7,#]
     * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the given tree is less than 4096.
     * -1000 <= node.val <= 1000
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        Node level_start = root;
        while (level_start != null) {
            Node curr = level_start;
            while (curr != null) {
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level_start = level_start.left;
        }
        return root;
    }

}
