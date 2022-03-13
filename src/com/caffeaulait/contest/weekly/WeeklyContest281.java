package com.caffeaulait.contest.weekly;

import com.caffeaulait.struct.ListNode;

import java.util.*;

public class WeeklyContest281 {

    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isEven(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num = num / 10;
        }
        return digitSum % 2 == 0;
    }

    public ListNode mergeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head.next;
        int sum = 0;
        while (curr != null) {
            if (curr.val != 0) {
                sum += curr.val;
            } else {
                list.add(sum);
                sum = 0;
            }
            curr = curr.next;
        }
        ListNode newHead = new ListNode(0);
        curr = newHead;
        for (int el : list) {
            curr.next = new ListNode(el);
            curr = curr.next;
        }
        return newHead.next;
    }


    public String repeatLimitedString(String s, int repeatLimit) {
        return s;
    }

    public long coutPairs(int[] nums, int k) {
        long count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] % k == 0) {
                count += nums.length-i-1;
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if ( (nums[i]*nums[j]) % k ==0) count++;
            }
        }
        return count;
    }

}
