package com.caffeaulait;

import java.util.*;

public class _0146_LRUCache {
    /**
     *
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
     * it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * LRUCache cache = new LRUCache
     *
     * cache.put(1, 1);
     * cache.put(2, 2);
     * cache.get(1);       // returns 1
     * cache.put(3, 3);    // evicts key 2
     * cache.get(2);       // returns -1 (not found)
     * cache.put(4, 4);    // evicts key 1
     * cache.get(1);       // returns -1 (not found)
     * cache.get(3);       // returns 3
     * cache.get(4);       // returns 4
     */
    class Node{
        Node prev, next;
        int key, value;
        Node (int k, int v){
            key = k;
            value = v;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public _0146_LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void offerNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            offerNode(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            offerNode(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                offerNode(node);
            } else {
                offerNode(node);
            }
            map.put(key, node);
        }
    }
}

class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };

    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}

class LRUCache2 {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int capacity;

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
            return map.get(key);
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
            map.put(key, value);
        } else {
            if (map.size() == capacity) {
                int k = queue.poll();
                map.remove(k);
                queue.offer(key);
            } else {
                queue.offer(key);
            }
            map.put(key, value);
        }
    }
}
