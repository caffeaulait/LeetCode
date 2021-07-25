package com.caffeaulait.problemset;

public class _0706_DesignHashMap {
    /**
     * Design a HashMap without using any built-in hash table libraries.
     *
     * To be specific, your design should include these functions:
     *
     * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
     * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
     *
     * Example:
     *
     * MyHashMap hashMap = new MyHashMap();
     * hashMap.put(1, 1);
     * hashMap.put(2, 2);
     * hashMap.get(1);            // returns 1
     * hashMap.get(3);            // returns -1 (not found)
     * hashMap.put(2, 1);          // update the existing value
     * hashMap.get(2);            // returns 1
     * hashMap.remove(2);          // remove the mapping for 2
     * hashMap.get(2);            // returns -1 (not found)
     *
     * Note:
     *
     * All keys and values will be in the range of [0, 1000000].
     * The number of operations will be in the range of [1, 10000].
     * Please do not use the built-in HashMap library.
     */

    final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public _0706_DesignHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = findPrev(nodes[i], key);
        if (prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) return -1;
        ListNode prev = findPrev(nodes[i], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) return;
        ListNode prev = findPrev(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findPrev(ListNode node, int key){
        ListNode curr = node, prev = null;
        while (curr!=null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int k, int v){
            key = k;
            val = v;
        }
    }
}
