package com.caffeaulait;

import java.util.*;

public class _0347_TopKFrequentElements {
    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int el : nums){
            map.put(el, map.getOrDefault(el,0)+1);
        }

        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.add(entry);
        }
        while (k>0){
            result.add(heap.poll().getKey());
            k--;
        }
        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k){
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int el : nums){
            map.put(el, map.getOrDefault(el,0)+1);
        }

        List<Integer> [] bucket = new List[nums.length+1];
        for (int el : map.keySet()){
            int freq = map.get(el);
            if (bucket[freq]==null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(el);
        }

        for (int i = bucket.length-1;i>0&&k>0;i--){
            if (bucket[i]!=null){
                List<Integer> list = bucket[i];
                result.addAll(list);
                k-=list.size();
            }
        }
        return result;
    }
}
