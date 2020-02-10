package com.caffeaulait;

public class nowcoder_06 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public int minNumberInRotateArray(int [] array){
        int lo = 0;
        int hi = array.length-1;
        while (lo <= hi){
            int mid = (lo+hi)>>1;
            if (array[mid] == array[hi]){
                //两边都可能，一个一个试
                hi = hi - 1;
            }else if(array[mid] > array[hi]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return array[lo];
    }
}
