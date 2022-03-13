package com.caffeaulait.contest.weekly;

import com.caffeaulait.struct.ListNode;

public class WeeklyContest223 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */
    public int[] decode(int[] encoded, int first) {
        //res[0] ^ res[1] = encoded[0]
        //res[0] ^ res[1] ^ res[0] = res[1] = encoded[0] ^ res[0];
        //res[1] ^ res[2] ^ res[1] = res[2] = encoded[1] ^ res[1];
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = encoded[i-1] ^ res[i-1];
        }
        return res;
    }


    public ListNode swapNodes(ListNode head, int k) {
        int len = getLength(head);
        if (len == 1) return head;
        int val1 = 0, val2 = 0;
        ListNode node1 = null, node2 = null;
        ListNode curr = head;
        for (int i = 1; i <= len; i++) {
            if (i == k) {
                node1 = curr;
                val1 = curr.val;
                if (node2 != null) break;
            }
            if (i == len - k + 1) {
                node2 = curr;
                val2 = curr.val;
                if (node1 != null) break;
            }
            curr = curr.next;
        }
        node1.val = val2;
        node2.val = val1;
        return head;
    }

    private int getLength(ListNode head){
        int len = 0;
        while (head!= null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
