package com.caffeaulait;

import java.nio.channels.Pipe;
import java.util.*;

public class WeeklyContest201 {
    /**
     * q1
     * q2
     * q3
     * q4
     */

    public String makeGood(String s) {
        if (s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char curr = chars[i];
            if (curr == 0) continue;
            char prev = curr;
            char next = 0;
            if (i < chars.length - 1) next = chars[i+1];
            int j = i - 1;
            while (j >= 0) {
                if (chars[j] != 0) {
                    prev = chars[j];
                    break;
                } else {
                    j--;
                }
            }
            if (i < chars.length - 1 && Math.abs(curr - next) == 32) {
                chars[i] = 0;
                chars[i+1] = 0;
            }else if (Math.abs(curr - prev) == 32){
                chars[i] = 0;
                chars[j] = 0;
            }
        }
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != 0) sb.append(chars[i]);
        }
        return sb.toString();
    }

    public char findKthBit(int n, int k) {
        String prev = "0";
        String curr = "0";
        String temp;
        int r = n;
        while ( n >  1) {
            curr = prev + "1";
            char[] pre = prev.toCharArray();
            invert(pre);
            reverse(pre);
            curr += String.valueOf(pre);
            prev = curr;
            n--;
        }
        return curr.charAt(k-1);
    }

    public void reverse(char[] data){
        int left = 0;
        int right = data.length - 1;

        while( left < right ) {
            // swap the values at the left and right indices
            char temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            // move the left and right index pointers in toward the center
            left++;
            right--;
        }
    }

    public void invert(char[] data){
        for (int i = 0; i < data.length;i++){
            if (data[i] == '0') data[i] = '1';
            else  data[i] = '0';
        }
    }
}
