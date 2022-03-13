package com.caffeaulait.nowcoder;

import com.caffeaulait.struct.ListNode;

public class nowcoder_31 {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if (len1 > len2){
            pHead1 = walkNStep(pHead1,len1-len2);
        }else{
            pHead2 = walkNStep(pHead2,len2-len1);
        }
        while (pHead1!=null){
            if (pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public int getLength(ListNode head){
        if (head == null)
            return 0;
        int sum = 0;
        while (head != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }

    ListNode walkNStep(ListNode head, int step){
        while (step>0){
            head = head.next;
            step--;
        }
        return head;
    }


}
