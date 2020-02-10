package com.caffeaulait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nowcoder_03 {
    /**
     * 输入一个链表，按链表从尾到投的顺序返回一个ArrayList
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode p = listNode;
        ArrayList<Integer> list = new ArrayList<>();
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }
        Collections.reverse(list);
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ListNode p = listNode;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(p!=null){
            stack.push(p.val);
            p=p.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
