package com.caffeaulait.nowcoder;

public class nowcoder_58 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */


    public int Add(int num1,int num2) {
        while ( num2 != 0 ){
            //两个数异或：相当于每一位相加，而不考虑进位；
            int sum = num1 ^ num2;
            //两个数相与，并左移一位：相当于求得进位；如果这一步的进位值为0，那么第一步得到的值就是最终结
            int carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
