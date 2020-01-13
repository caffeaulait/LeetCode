package com.caffeaulait;

import java.util.HashSet;
import java.util.Set;

public class nowcoder_50 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : array){
            if(!set.contains(i)){
                set.add(i);
            }else{
                set.remove(i);
            }
        }
        Object[] arr = set.toArray();
        num1[0] = (int) arr[0];
        num2[0] = (int) arr[1];
    }
}
