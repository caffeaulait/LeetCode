package com.caffeaulait;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class nowcoder_25 {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (k>input.length){
            return result;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i =0;i<input.length;i++){
            queue.offer(input[i]);
        }

        while (k>0){
            result.add(queue.poll());
            k--;
        }
        return result;
    }
}
