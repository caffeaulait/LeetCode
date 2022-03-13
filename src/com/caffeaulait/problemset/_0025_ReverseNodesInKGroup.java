package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

public class _0025_ReverseNodesInKGroup {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     *
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *
     * Example:
     *
     * Given this linked list: 1->2->3->4->5
     *
     * For k = 2, you should return: 2->1->4->3->5
     *
     * For k = 3, you should return: 3->2->1->4->5
     *
     * Note:
     *
     * Only constant extra memory is allowed.
     * You may not alter the values in the list's nodes, only nodes itself may be changed.
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        dummy.next = head;
        int i = 0;
        while (head!=null){
            i++;
            if (i % k ==0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }



    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin, curr = begin.next;
        ListNode first = curr;
        while (curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}
