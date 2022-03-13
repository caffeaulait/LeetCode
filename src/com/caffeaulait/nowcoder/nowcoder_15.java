package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.ListNode;

public class nowcoder_15 {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public ListNode ReverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
