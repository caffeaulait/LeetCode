package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

public class _0061_RotateList {
    /**
     * 61. Rotate List
     * Medium
     *
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     *
     * Example 1:
     *
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * Example 2:
     *
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        ListNode end = head, pivot = head;
        while (end.next!=null){
            len++;
            end = end.next;
        }

        //move the list after the (len - k % len)th node to the front
        k %= len;
        for (int i = len - k; i>1; i--){
            pivot = pivot.next;
        }

        end.next =  head;
        head = pivot.next;
        pivot.next = null;

        return head;

//        - - - - - ~ ~ ~
//                p     e
//
//        ~ ~ ~ - - - - -

    }
}
