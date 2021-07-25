package com.caffeaulait.problemset;

import java.util.Arrays;
import java.util.TreeMap;

public class _0352_DataStreamAsDisjointIntervals {
    TreeMap<Integer, int[]> map;

    /** Initialize your data structure here. */
    public _0352_DataStreamAsDisjointIntervals() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if (l != null && h != null && map.get(l)[1] + 1 == val && h == val + 1){
            map.get(l)[1] = map.get(h)[1];
            map.remove(h);
        }else if (l != null && map.get(l)[1] + 1 >= val) {
            map.get(l)[1] = Math.max(map.get(l)[1], val);
        }else if (h != null && h == val + 1) {
            map.put(val, new int[]{val, map.get(h)[1]});
            map.remove(h);
        }else {
            map.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[map.size()][]);
    }
}
