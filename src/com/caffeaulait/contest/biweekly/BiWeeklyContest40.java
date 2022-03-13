package com.caffeaulait.contest.biweekly;

import com.caffeaulait.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class BiWeeklyContest40 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            res++;
            sb.append(word);
        }
        return res;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = getNthNode(list1, a-1);
        ListNode post = getNthNode(list1, b+1);
        prev.next = list2;
        ListNode end = getEnd(list2);
        end.next = post;
        return list1;
    }

    private ListNode getNthNode(ListNode head, int n) {
        ListNode curr = head;
        while ( n > 0 ) {
            curr = curr.next;
            n--;
        }
        return curr;
    }

    private ListNode getEnd(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    class FrontMiddleBackQueue {

        List<Integer> list;

        public FrontMiddleBackQueue() {
            list = new ArrayList<>();
        }

        public void pushFront(int val) {
            list.add(0, val);
        }

        public void pushMiddle(int val) {
            int index = list.size() / 2;
            list.add(index, val);
        }

        public void pushBack(int val) {
            list.add(val);
        }

        public int popFront() {
            if (list.size() == 0) return -1;
            return list.remove(0);
        }

        public int popMiddle() {
            if (list.size() == 0) return -1;
            int index = (list.size() + 1) / 2 - 1;
            return list.remove(index);
        }

        public int popBack() {
            if (list.size() == 0) return -1;
            return list.remove(list.size()-1);
        }
    }
}


