package com.caffeaulait;

import java.util.HashSet;
import java.util.Set;

public class nowcoder_47 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     * 那么对应的输出是第一个重复的数字2。
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length==0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<numbers.length;i++){
            int num = numbers[i];
            if (num<0||num >=length)
                return false;
            if (set.contains(num)){
                duplication[0]=num;
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}
