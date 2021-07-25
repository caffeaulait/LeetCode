package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;

public class _0143_ReorderList {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     * Example 1:
     *
     * Given 1->2->3->4, reorder it to 1->4->2->3.
     * Example 2:
     *
     * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next==null) return;

        //Find the middle of the list
        ListNode p1 = head, p2 = head;
        while (p2.next!=null && p2.next.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }


        //reverse the second half
        ListNode prev = null, curr = p1.next;
        while (curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        p1.next = prev;


        //reorder one by one
        ListNode preMid = p1;
        p2 = p1.next;
        p1 = head;
        while (p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }

    }

}
