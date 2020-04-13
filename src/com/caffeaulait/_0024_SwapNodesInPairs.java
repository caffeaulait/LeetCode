package com.caffeaulait;

public class _0024_SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     *
     *
     * Example:
     *
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next!=null && curr.next.next!=null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            second.next = first;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
