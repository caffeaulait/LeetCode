package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.ListNode;

public class nowcoder_28 {
    /**
     *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode curr = pHead;
        ListNode prev = head;
        while (curr!=null){
            if (curr.next!=null && curr.val == curr.next.val){
                while (curr.next!=null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head.next;
    }
}
