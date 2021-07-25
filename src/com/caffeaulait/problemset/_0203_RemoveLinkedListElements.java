package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;

public class _0203_RemoveLinkedListElements {
    /**
     * Remove all elements from a linked list of integers that have value val.
     *
     * Example:
     *
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     */

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr!=null){
            if (curr.val == val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
