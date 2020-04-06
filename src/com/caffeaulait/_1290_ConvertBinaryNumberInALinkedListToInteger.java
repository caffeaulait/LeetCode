package com.caffeaulait;

public class _1290_ConvertBinaryNumberInALinkedListToInteger {
    /**
     * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
     *
     * Return the decimal value of the number in the linked list.
     */
    public int getDecimalValue(ListNode head) {
        int value = 0;
        while(head!=null){
            value <<= 1;
            value += head.val;
            head = head.next;
        }
        return value;
    }
}
