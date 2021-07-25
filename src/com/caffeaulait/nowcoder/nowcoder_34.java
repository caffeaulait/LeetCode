package com.caffeaulait.nowcoder;

public class nowcoder_34 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0){
            B[0] = 1;
            //左下
            int temp = 1;
            for (int i = 1; i<length;i++){
                temp *= A[i-1];
                B[i] = temp;
            }
            temp = 1;
            for (int j = length - 2;j>=0;j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
