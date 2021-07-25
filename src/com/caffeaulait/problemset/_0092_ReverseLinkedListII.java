package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;

public class _0092_ReverseLinkedListII {
    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     *
     * Note: 1 ≤ m ≤ n ≤ length of list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        int i = 1;
        while (i < m){
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode preStart = prev;

        while (i <= n){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }

        preStart.next.next = curr;
        preStart.next = prev;
        return dummy.next;
    }
}
