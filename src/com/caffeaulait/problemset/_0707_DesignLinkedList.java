package com.caffeaulait.problemset;

public class _0707_DesignLinkedList {
    /**
     * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
     * <p>
     * Implement these functions in your linked list class:
     * <p>
     * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * addAtTail(val) : Append a node of value val to the last element of the linked list.
     * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
     */

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public _0707_DesignLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        if (size == 1) {
            return head.val;
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node n = new Node(val);
            n.next = head;
            head = n;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node cur = head;
            for (int i = 0; i < size - 1; i++) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;

            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

