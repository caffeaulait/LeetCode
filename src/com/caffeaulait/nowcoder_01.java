package com.caffeaulait;

public class nowcoder_01 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int target, int [][] array) {
        for(int i = 0; i<array.length;i++){
            int lo = 0;
            int hi = array[i].length-1;
            while(lo <= hi){
                int mid = (lo+hi)/2;
                if(array[i][mid] == target){
                    return true;
                }else if(array[i][mid] > target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
        }
        return false;
    }
}
