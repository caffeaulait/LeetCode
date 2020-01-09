package com.caffeaulait;

import java.util.Comparator;
import java.util.PriorityQueue;

public class nowcoder_48 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
     * 使用GetMedian()方法获取当前读取数据的中位数。
     */

    /**
     * 主要思想 大顶堆存较小的数字，小顶堆存较大的数字.中位数就是两这root平均值
     * 小顶堆中的元素均大于大顶堆的元素
     * 两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
     */

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;


    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else{
            return minHeap.peek()*1.0;
        }
    }

}
