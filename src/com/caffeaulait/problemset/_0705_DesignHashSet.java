package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0705_DesignHashSet {
    /**
     * Design a HashSet without using any built-in hash table libraries.
     *
     * To be specific, your design should include these functions:
     *
     * add(value): Insert a value into the HashSet.
     * contains(value) : Return whether the value exists in the HashSet or not.
     * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
     *
     * Example:
     *
     * MyHashSet hashSet = new MyHashSet();
     * hashSet.add(1);
     * hashSet.add(2);
     * hashSet.contains(1);    // returns true
     * hashSet.contains(3);    // returns false (not found)
     * hashSet.add(2);
     * hashSet.contains(2);    // returns true
     * hashSet.remove(2);
     * hashSet.contains(2);    // returns false (already removed)
     */
    boolean[] arr = new boolean[100];

    public _0705_DesignHashSet() {

    }

    public void add(int key) {
        if (key >= arr.length) {
            extend(key);
        }
        arr[key] = true;
    }

    public void remove(int key) {
        if (key >= arr.length){
            extend(key);
        }
        arr[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key >= arr.length) {
            return false;
        }
        return arr[key] == true;
    }

    public void extend(int key){
        arr = Arrays.copyOf(arr, key + 2);
    }
}
