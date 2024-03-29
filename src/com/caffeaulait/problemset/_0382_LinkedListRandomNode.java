package com.caffeaulait.problemset;

import com.caffeaulait.struct.ListNode;

import java.util.Random;

public class _0382_LinkedListRandomNode {
    /**
     *
     Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

     Follow up:
     What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

     Example:

     // Init a singly linked list [1,2,3].
     ListNode head = new ListNode(1);
     head.next = new ListNode(2);
     head.next.next = new ListNode(3);
     Solution solution = new Solution(head);

     // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
     solution.getRandom();
     */

    ListNode head;
    Random rand;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public _0382_LinkedListRandomNode(ListNode head) {
         rand = new Random();
         this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        ListNode curr = head;
        ListNode candidate = head;

        while (curr!=null) {
            if (rand.nextInt(count+1) == count) candidate = curr;
            curr = curr.next;
            count++;
        }
        return candidate.val;
    }
}
