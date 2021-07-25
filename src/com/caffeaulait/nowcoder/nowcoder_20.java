package com.caffeaulait.nowcoder;

import java.util.Stack;

public class nowcoder_20 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()||node<=minStack.peek())
            minStack.push(node);
    }

    public void pop() {
        if(stack.peek()==minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
