package com.caffeaulait.nowcoder;

public class nowcoder_01 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int target, int [][] array) {
        int rows = array.length-1;
        int cols = array[0].length-1;
        int r = 0, c = cols;
        while (r<=rows && c>=0){
            if (array[r][c] == target){
                return true;
            }else if (array[r][c] < target){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
}
