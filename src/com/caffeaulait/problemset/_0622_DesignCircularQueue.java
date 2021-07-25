package com.caffeaulait.problemset;


public class _0622_DesignCircularQueue {
    /**
     * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
     *
     * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
     *
     * Implementation the MyCircularQueue class:
     *
     * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
     * int Front() Gets the front item from the queue. If the queue is empty, return -1.
     * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
     * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
     * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
     * boolean isEmpty() Checks whether the circular queue is empty or not.
     * boolean isFull() Checks whether the circular queue is full or not.
     */
    class MyCircularQueue {
        int[] arr;
        int size;
        int capacity;
        int front;
        int back;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            arr = new int[k];
            capacity = k;
            size = 0;
            front = 0;
            back = -1;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size == capacity) {
                return false;
            }
            back++;
            arr[back % capacity] = value;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            front++;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return size == 0 ? -1 : arr[front%capacity];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return size == 0 ? - 1: arr[back%capacity];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == capacity;
        }

    }

}
