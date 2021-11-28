package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest269 {

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) res.add(i);
        }
        return res;
    }

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        double sum = 0;
        int size = 2*k+1;
        if (n < size) {
            return res;
        }
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        for (int i = k; i < n - k; i++) {
            res[i] = (int) (sum/size);
            sum -= nums[i-k];
            if (i+k+1<n) sum += nums[i+k+1];
        }
        return res;
    }

    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIndex = 0, minIndex = 0;
        for (int i= 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                maxIndex = i;
            }
            if (num < min) {
                min = num;
                minIndex = i;
            }
        }
        int left = 0, right = 0;
        if (maxIndex < minIndex) {
            left = maxIndex;
            right = minIndex;
        } else {
            left = minIndex;
            right = maxIndex;
        }
        return Math.min(left+1+nums.length-right ,Math.min(right+1, nums.length-left));
    }


    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2]-b[2]);
        for (int[] meeting : meetings) {
            int a = meeting[0], b = meeting[1];
            if (res.contains(a) || res.contains(b)) {
                res.add(a);
                res.add(b);
            }
        }
        return new ArrayList<>(res);
    }
}
