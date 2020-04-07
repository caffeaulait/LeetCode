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

    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min = -1;

    public _0460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.vals = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
        this.lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size()==0) {
            min++;
        }
        if (!lists.containsKey(count+1)) {
            lists.put(count+1, new LinkedHashSet<>());
        }
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key); // update key's count
            return;
        }
        if (vals.size() >= capacity) {
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

}
