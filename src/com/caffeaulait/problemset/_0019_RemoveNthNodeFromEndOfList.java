package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

public class _0019_RemoveNthNodeFromEndOfList {
    /**
     *Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     *
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     *
     * Given n will always be valid.
     *
     * Follow up:
     *
     * Could you do this in one pass?
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = head, prev = dummy;
        int i = 0;
        while (fast!=null){
            fast = fast.next;
            i++;
            if (i > n){
                prev = slow;
                slow = slow.next;
            }
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
