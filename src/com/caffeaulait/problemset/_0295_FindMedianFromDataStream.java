package com.caffeaulait.problemset;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0295_FindMedianFromDataStream {
    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
     *
     * For example,
     * [2,3,4], the median is 3
     *
     * [2,3], the median is (2 + 3) / 2 = 2.5
     *
     * Design a data structure that supports the following two operations:
     *
     * void addNum(int num) - Add a integer number from the data stream to the data structure.
     * double findMedian() - Return the median of all elements so far.
     *
     *
     * Example:
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     *
     * Follow up:
     *
     * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
     * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
     */
    /** initialize your data structure here. */

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b - a);

    public _0295_FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek())/2.0;
    }

    /**
     * max 0 1 1 1 2 2
     * min 1 0 1 2 1 2
     */
}
