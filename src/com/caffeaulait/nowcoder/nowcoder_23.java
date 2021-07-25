package com.caffeaulait.nowcoder;

public class nowcoder_23 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     */

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    public boolean judge(int[] arr, int left ,int right){
        if(left >= right)
            return true;
        int i = right;
        while(i>left && arr[i-1]>arr[right]) i--;
        for(int j = i-1;j>=left;j--){
            if(arr[j]>arr[right])
                return false;
        }
        return judge(arr,left,i-1) && judge(arr,i,right-1);
    }
}
