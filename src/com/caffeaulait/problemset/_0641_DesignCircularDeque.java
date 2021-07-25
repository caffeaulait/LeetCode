package com.caffeaulait.problemset;

public class _0641_DesignCircularDeque {
    /**
     * Design your implementation of the circular double-ended queue (deque).
     *
     * Your implementation should support following operations:
     *
     * MyCircularDeque(k): Constructor, set the size of the deque to be k.
     * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
     * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
     * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
     * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
     * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
     * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
     * isEmpty(): Checks whether Deque is empty or not.
     * isFull(): Checks whether Deque is full or not.
     *
     *
     * Example:
     *
     * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
     * circularDeque.insertLast(1);			// return true
     * circularDeque.insertLast(2);			// return true
     * circularDeque.insertFront(3);			// return true
     * circularDeque.insertFront(4);			// return false, the queue is full
     * circularDeque.getRear();  			// return 2
     * circularDeque.isFull();				// return true
     * circularDeque.deleteLast();			// return true
     * circularDeque.insertFront(4);			// return true
     * circularDeque.getFront();			// return 4
     */

    class MyCircularDeque {
        int size;
        int k;
        Node head;
        Node tail;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
            this.k = k;
            this.size = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (size == k) {
                return false;
            }
            Node node = new Node(value);
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (size == k) {
                return false;
            }
            Node node = new Node(value);
            Node temp = tail.prev;
            temp.next = node;
            node.prev = temp;
            node.next = tail;
            tail.prev = node;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            Node temp = head.next;
            head.next = temp.next;
            temp.next.prev = head;
            temp.next = null;
            temp.prev = null;
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            Node temp = tail.prev;
            tail.prev = temp.prev;
            temp.prev.next = tail;
            temp.prev = null;
            temp.next = null;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (size == 0) {
                return -1;
            }
            return head.next.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (size == 0) {
                return -1;
            }
            return tail.prev.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == k;
        }

        class Node {
            Node next;
            Node prev;
            int val;
            public Node(int val) {this.val = val;}
        }
    }

}