package com.caffeaulait.nowcoder;


import com.caffeaulait.miscellaneous.ListNode;

public class nowcoder_14 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (fast != null){
            fast = fast.next;
            //fast领先k步后slow开始走
            if(i>=k){
                slow=slow.next;
            }
            i++;
        }
        return i < k?null:slow;
    }
}
