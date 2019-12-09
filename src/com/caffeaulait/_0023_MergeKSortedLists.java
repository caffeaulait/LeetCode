package com.caffeaulait;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0023_MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val){
                    return -1;
                }else if(o1.val > o2.val){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        for (int i = 0; i<lists.length; i++){
            queue.offer(lists[i]);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next!=null)
                queue.offer(curr.next);
        }
        return head.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length==0||lists==null)
            return null;
        if (lists.length==1)
            return lists[0];
        int mid = lists.length/2;
        ListNode [] list1 = Arrays.copyOfRange(lists,0,mid);
        ListNode [] list2 = Arrays.copyOfRange(lists,mid,lists.length);
        return merge(mergeKLists2(list1),mergeKLists2(list2));
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                curr.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1!=null)
            curr.next = l1;
        else
            curr.next = l2;
        return result.next;
    }
}
