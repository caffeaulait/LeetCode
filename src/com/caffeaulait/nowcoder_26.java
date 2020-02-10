package com.caffeaulait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class nowcoder_26 {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        q2.offer(2);
        q3.offer(3);
        q5.offer(5);
        while (index>1){
            int ugly = Math.min(q2.peek(),Math.min(q3.peek(),q5.peek()));
            list.add(ugly);
            if (ugly == q2.peek()){
                q2.poll();
            }
            if (ugly == q3.peek()){
                q3.poll();
            }
            if (ugly == q5.peek()){
                q5.poll();
            }
            q2.offer(ugly*2);
            q3.offer(ugly*3);
            q5.offer(ugly*5);
            index--;
        }
        return list.get(list.size()-1);
    }
}
