package com.caffeaulait.nowcoder;

import java.util.ArrayList;

public class nowcoder_40 {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array==null || array.length==0)
            return result;
        int left = 0, right = array.length-1;
        while (left < right){
            int total = array[left] + array[right];
            if (total == sum){
                result.add(array[left]);
                result.add(array[right]);
                break;
            }else if (total < sum){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}
