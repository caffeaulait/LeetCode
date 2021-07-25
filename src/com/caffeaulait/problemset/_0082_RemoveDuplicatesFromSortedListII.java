package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;

public class _0082_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr!=null){
            if (curr.next!=null && curr.val == curr.next.val){
                while (curr.next!=null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
