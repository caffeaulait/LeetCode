package com.caffeaulait.contest.weekly;

public class WeeklyContest285 {

    public int countHillValley(int[] nums) {
        int count = 0;
        boolean prev = false;
        for (int i = 1; i < nums.length;i++) {
            if (prev && nums[i] == nums[i-1]) {
                continue;
            }
            if (isValleyOrHill(nums, i)) {
                count++;
                prev = true;
            } else {
                prev = false;
            }
         }
        return count;
    }

    public boolean isValleyOrHill(int[] nums, int index) {
        int i = index - 1, j = index + 1;
        while (i >= 0 && nums[i] == nums[index]) i--;
        while (j < nums.length && nums[j] == nums[index]) j++;
        if (i < 0 || j >= nums.length) {
            return false;
        }
        return (nums[i] > nums[index] && nums[j] > nums[index]) || (nums[i] < nums[index] && nums[j] < nums[index]);
    }

    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        return loopOnce(chars);
    }

    public int loopOnce(char[] chars){
        int incr = 0;
        for (int i = 1 ; i < chars.length; i++) {
            if (chars[i-1] == 'R' && chars[i] == 'S') {
                chars[i-1] = 'S';
                incr++;
                int j = i-2;
                while (j >= 0 && chars[j] == 'R') {
                    chars[j] = 'S';
                    incr++;
                    j--;
                }
            } else if(chars[i-1] == 'S' && chars[i] == 'L') {
                chars[i] = 'S';
                incr++;
            } else if (chars[i-1] == 'R' && chars[i] == 'L'){
                chars[i] = 'S';
                chars[i-1] = 'S';
                incr+=2;
                int j = i-2;
                while (j >= 0 && chars[j] == 'R') {
                    chars[j] = 'S';
                    incr++;
                    j--;
                }
            }
        }
        return incr;
    }
}
