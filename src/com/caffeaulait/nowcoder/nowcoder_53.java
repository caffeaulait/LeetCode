package com.caffeaulait.nowcoder;

public class nowcoder_53 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    private long cnt = 0;
    private int[] tmp;

    public int InversePairs(int [] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length-1);
        return (int) (cnt % 1000000007);
    }

    public void mergeSort(int[] nums, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi){
        int i = lo, j = mid+1, k = lo;
        while (i <= mid && j <= hi){
            if (nums[i] > nums[j]){
                tmp[k++] = nums[j++];
                cnt += mid - i + 1; // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }else{
                tmp[k++] = nums[i++];
            }
        }
        while (i<=mid){
            tmp[k++] = nums[i++];
        }
        while (j<=hi){
            tmp[k++] = nums[j++];
        }

        for (k = lo; k<=hi; k++){
            nums[k] = tmp[k];
        }
    }

}
