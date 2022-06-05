package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest296 {
    public int minMaxGame(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] newNums = new int[nums.length / 2];
        for(int i = 0; i < nums.length / 2; i++) {
            if(i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    public int partitionArray(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int small = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - small > k) {
                count++;
                small = nums[i];
            }
        }
        return count;
    }


    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] op : operations) {
            int index = map.get(op[0]);
            map.remove(op[0]);
            map.put(op[1], index);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int index = entry.getValue();
            nums[index] = val;
        }
        return nums;
    }

    class TextEditor {
        List<Character> chars;
        int pos;
        public TextEditor() {
            chars = new ArrayList<>();
            pos = 0;
        }

        public void print() {
            System.out.print("str is: " + getStr() +", cursor at: " + pos +"\n");
        }

        public String getStr() {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) sb.append(c);
            return sb.toString();
        }

        public void addText(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (pos >= chars.size()) {
                    chars.add(text.charAt(i));
                }else{
                    chars.add(pos, text.charAt(i));
                }
                pos++;
            }
            print();
        }

        public int deleteText(int k) {
            int count = 0;
            int i = pos-1;
            for (; i >=0 ;i--) {
                chars.remove(i);
                count++;
                pos--;
                if (count >= k) {
                    break;
                }
            }
            print();
            return count;
        }

        public String cursorLeft(int k) {
            for (int i = 0; i < k; i++) {
                if (pos <= 0) break;
                pos--;
            }
            String str = getStr();
            int left = Math.max(0, Math.min(10, pos));
            print();
            return str.substring(pos-left, pos);
        }

        public String cursorRight(int k) {
            for (int i = 0; i < k; i++) {
                if (pos >= chars.size()) break;
                pos++;
            }
            String str = getStr();
            int left = Math.max(0, Math.min(10, pos));
            print();
            return str.substring(pos-left, pos);
        }
    }
}
