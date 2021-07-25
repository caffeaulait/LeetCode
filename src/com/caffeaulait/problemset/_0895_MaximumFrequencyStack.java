package com.caffeaulait.problemset;


import java.util.*;

public class _0895_MaximumFrequencyStack {
    /**
     * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
     *
     * FreqStack has two functions:
     *
     * push(int x), which pushes an integer x onto the stack.
     * pop(), which removes and returns the most frequent element in the stack.
     * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
     *
     *
     * Example 1:
     *
     * Input:
     * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
     * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
     * Output: [null,null,null,null,null,null,null,5,7,5,4]
     * Explanation:
     * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
     *
     * pop() -> returns 5, as 5 is the most frequent.
     * The stack becomes [5,7,5,7,4].
     *
     * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
     * The stack becomes [5,7,5,4].
     *
     * pop() -> returns 5.
     * The stack becomes [5,7,4].
     *
     * pop() -> returns 4.
     * The stack becomes [5,7].
     */
    class Node {
        int value;
        int freq;
        int index;

        public Node(int v, int f, int i){
            value = v;
            freq = f;
            index = i;
        }
    }

    Queue<Node> queue;
    Map<Integer, Integer> map;
    int index = 0;

    public _0895_MaximumFrequencyStack() {
        queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.freq != o2.freq) return o2.freq - o1.freq;
                else return o2.index - o1.index;
            }
        });
        map = new HashMap<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
        queue.offer(new Node(x, map.get(x), ++index));
    }

    public int pop() {
        Node node = queue.poll();
        map.put(node.value, map.get(node.value)-1);
        return node.value;
    }
}
