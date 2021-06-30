package com.caffeaulait;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class _0460_LFUCache {
    /**
     * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
     *
     * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
     *
     *
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     *
     *
     * Example:
     *
     * LFUCache cache = new LFUCache( 2 /* capacity */

    class Node {
        int key, val, cnt;
        Node next, prev;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.cnt = 1;
        }
    }

    class DoublyList {
        Node head, tail;
        int size;
        public DoublyList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        public void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        public Node remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
            return node;
        }

    }

    private int cap;
    private int size;
    private int min;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoublyList> countMap;

    public _0460_LFUCache(int capacity) {
        cap = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
        }else{
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == cap) {
                DoublyList list = countMap.get(min);
                nodeMap.remove(list.remove(list.tail.prev).key);
                size--;
            }
            size++;
            min = 1;
            DoublyList newList = countMap.getOrDefault(1, new DoublyList());
            newList.add(node);
            countMap.put(1, newList);
        }
    }

    public void update(Node node) {
        DoublyList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        if (oldList.size == 0 && node.cnt == min) min++;
        node.cnt++;
        DoublyList newList = countMap.getOrDefault(node.cnt, new DoublyList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }

}
