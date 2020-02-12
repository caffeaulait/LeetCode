package com.caffeaulait;

import java.util.HashMap;
import java.util.Map;

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

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node popTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }


    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    private Map<Integer,Node> map = new HashMap<>();
    private int capacity;
    private int count = 0;

    public _0146_LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = map.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            count++;
            if (count > capacity){
                Node tail = popTail();
                map.remove(tail.key);
                count--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }


}
