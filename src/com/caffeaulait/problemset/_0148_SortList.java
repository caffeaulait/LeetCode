package com.caffeaulait.problemset;

public class _0148_SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example 1:
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     *
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     */
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = null, slow = head, fast = head;

        while (fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        p.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = new ListNode(l1.val);
                l1 = l1.next;
                p = p.next;
            }else{
                p.next = new ListNode(l2.val);
                l2 = l2.next;
                p = p.next;
            }
        }

        if (l1 == null){
            p.next = l2;
        }else{
            p.next = l1;
        }
        return head.next;
    }


}
