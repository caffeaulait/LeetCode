package com.caffeaulait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nowcoder_13 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int [] array) {
        int[] copy = Arrays.copyOf(array,array.length);
        int k = 0;
        for (int i = 0;i<copy.length;i++){
            if (copy[i]%2==1)
                array[k++]=copy[i];
        }
        for (int i = 0;i<copy.length;i++){
            if (copy[i]%2==0)
                array[k++]=copy[i];
        }
    }
}
