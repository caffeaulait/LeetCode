package com.caffeaulait.problemset;

public class _0021_MergeTwoSortedLists {
    /**
     * #21
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next=null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                p.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                p.next = new ListNode(l2.val);
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1 == null){
            p.next = l2;
        }else{
            p.next = l1;
        }
        return head.next;
    }
}
