package com.caffeaulait.problemset;

public class _0338_CountingBits {
    /**
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     *
     * Example 1:
     *
     * Input: 2
     * Output: [0,1,1]
     * Example 2:
     *
     * Input: 5
     * Output: [0,1,1,2,1,2]
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++){
            if ( (i & 1) == 0){
                res[i] = res[i>>1];
            }else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
}
