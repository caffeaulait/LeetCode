package com.caffeaulait.nowcoder;

public class nowcoder_07 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */

    //递归法，可能造成栈溢出
    public int Fibonacci(int n){
        if (n==0 || n == 1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //迭代法
    public int Fibonacci1(int n){
        int f = 0, g = 1;
        while (n > 0){
            g = g + f;
            f = g - f;
            n--;
        }
        return f;
    }

    //尾递归法
    public int Fibonacci2(int n){
        return fib(n,0,1);
    }

    public int fib(int n, int acc1, int acc2){
        if (n==0)
            return 0;
        if (n==1)
            return acc2;
        return fib(n-1,acc2,acc1+acc2);
    }

}


