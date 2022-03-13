package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

public class _0086_PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Example:
     *
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     */

    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(0);
        ListNode qHead = new ListNode(0);
        ListNode p = pHead, q = qHead;
        while (head!=null) {
            if (head.val < x){
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = qHead.next;
        return pHead.next;
    }
}
