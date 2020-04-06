package com.caffeaulait;

public class _0138_CopyListWithRandomPointer {
    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     *
     * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
     *
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr!=null){
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = head;
        while (curr!=null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

        Node cHead = head.next;
        curr = head;
        while (curr!=null){
            Node clone = curr.next;
            curr.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            curr = curr.next;
        }

        return cHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
