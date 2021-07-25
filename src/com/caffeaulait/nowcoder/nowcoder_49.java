package com.caffeaulait.nowcoder;

public class nowcoder_49 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int lo = 0, hi = array.length-1;
        while (lo <= hi){
            int mid = (lo + hi)>>1;
            if (array[mid] == k){
                count++;
                count+=expandAround(array,mid);
                break;
            }else if (array[mid] < k){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return count;
    }

    public int expandAround(int [] array, int index){
        int count = 0;
        int num = array[index];
        int left = index-1, right = index+1;
        while (left >=0 && array[left] == num){
            count++;
            left--;
        }
        while (right <array.length && array[right] == num){
            count++;
            right++;
        }
        return count;
    }
}
