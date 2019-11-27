package com.caffeaulait;

public class _0002_AddTwoNumbers {

    /**
     * #2
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     * Example:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        int extra = 0;
        while (l1 != null || l2 !=null || extra != 0){
            int x = l1 != null? l1.val : 0;
            int y = l2 != null? l2.val : 0;
            int sum = x + y + extra;
            extra = sum / 10;
            p.next = new ListNode(sum%10);
            p = p.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;

    }
}
