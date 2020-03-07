package com.caffeaulait;

public class _0147_InsertionSortList {
    /**
     * Algorithm of Insertion Sort:
     *
     * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
     * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
     * It repeats until no input elements remain.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;  // the node to be inserted
        ListNode prev = dummy;
        ListNode temp = null;
        while (curr!=null){
            temp = curr.next;
            while (prev.next!=null && prev.next.val<curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            prev = dummy;
            curr = temp;
        }
        return dummy.next;
    }   
}
