package com.caffeaulait;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRUCache {
    /**
     *
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
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

    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    private Map<Integer,Node> map = new HashMap<>();
    private int capacity;
    private int size = 0;

    public _0146_LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    //insert after the head
    private void add(Node node){
        map.put(node.key, node);
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
        size++;
    }

    //delete the node
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private void moveToHead(Node node){
        remove(node);
        add(node);
    }

    private void popTail(){
        Node node = tail.prev;
        remove(node);
    }

    public int get(int key){
        Node node = map.get(key);
        if (node != null){
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        Node node = map.get(key);
        if (node != null){
            node.value = value;
            moveToHead(node);
        }else{
            Node newNode = new Node(key,value);
            add(newNode);
            if (size==capacity){
                popTail();
            }
        }
    }
}
