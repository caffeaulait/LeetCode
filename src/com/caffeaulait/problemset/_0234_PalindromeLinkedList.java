package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.ListNode;

public class _0234_PalindromeLinkedList {
    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd nodes: let right half smaller
        if (fast!=null) slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow!=null){
            if (fast.val!=slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
