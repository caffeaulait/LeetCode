package com.caffeaulait.problemset;

import java.util.PriorityQueue;
import java.util.Queue;

public class _1046_LastStoneWeight {
    /**
     * We have a collection of stones, each stone has a positive integer weight.
     *
     * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
     *
     * If x == y, both stones are totally destroyed;
     * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
     * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
     *
     *
     *
     * Example 1:
     *
     * Input: [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        Queue<Integer> heap = new PriorityQueue<>((a,b) ->(b-a));
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size()>1){
            int large =  heap.poll();
            int small = heap.poll();
            if (large > small) heap.offer(large-small);
        }
        return heap.size() == 1 ? heap.poll() : 0;
    }
}
