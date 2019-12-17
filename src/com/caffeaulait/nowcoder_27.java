package com.caffeaulait;

public class nowcoder_27 {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;

        //判断是否有环
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        //无环
        if (fast == null || fast.next ==null)
            return null;

        //有环,一个从起始点出发，另一个从相遇点出发，会在入口点碰面
        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
