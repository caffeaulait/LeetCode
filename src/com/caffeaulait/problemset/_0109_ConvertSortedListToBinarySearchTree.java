package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;
import com.caffeaulait.miscellaneous.TreeNode;

public class _0109_ConvertSortedListToBinarySearchTree {
    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted linked list: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode mid = getMidNode(head);

        TreeNode root = new TreeNode(mid.val);

        if (head == mid) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode getMidNode(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev!=null) prev.next = null;

        return slow;
    }
}
