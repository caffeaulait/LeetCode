package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

public class _0142_LinkedListCycleII {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        if (fast==null || fast.next==null)
            return null;

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
