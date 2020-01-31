package com.caffeaulait;

import java.util.List;

public class _0083_RemoveDuplicatesFromSortedList {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * Example 1:
     *
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            if (curr.val == curr.next.val)
                //do not move curr pointer
                curr.next = curr.next.next;

            else
                curr = curr.next;
        }
        return head;
    }
}
