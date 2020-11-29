package com.caffeaulait;

import java.util.*;

public class WeeklyContest217 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */

    public int maximumWealth(int[][] accounts) {
        List<Integer> list = new ArrayList<>();
        for (int[] account : accounts) {
            int sum = getSum(account);
            list.add(sum);
        }
        return Collections.max(list);
    }

    private int getSum(int[] account) {
        int res = 0;
        for (int a : account) res += a;
        return res;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        if (isSpecial(nums)) return Arrays.copyOfRange(nums,0, k);
        int size = nums.length;
        int start = 0;
        int[] res = new int[k];
        int count = 0;
        while ( k > 0) {
            int index = getSmallest(nums, start, size - k + 1);
            res[count] = nums[index];
            start = index + 1;
            k--;
            count++;
        }
        return res;
    }

    private int getSmallest(int[] nums, int start, int end) {
        int i = start;
        for (int j = start + 1; j < end; j++) {
            if (nums[j] < nums[i]) i = j;
        }
        return i;
    }

    private boolean isSpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) return false;
        }
        return true;
    }

    public int minMoves(int[] nums, int limit) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int sum = nums[i] + nums[size-1-i];
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        map.entrySet()
           .stream()
           .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
           .forEach(el -> list.add(el.getKey()));
        List<Integer> res = new ArrayList<>();
        for (int sum : list) {
            int cost = getCost(nums, sum, limit);
            if (cost != -1) res.add(cost);
        }
        return Collections.min(res);
    }

    private int canReplace(int fst, int snd, int target, int limit){
        int sum = fst + snd;
        if (sum == target) return 0;
        if ((target - fst <= limit && target - fst > 0)
         || (target - snd <= limit && target - snd > 0)) return 1;
        if (target <= 2 * limit) return 2;
        return -1;
    }

    private int getCost(int[] nums, int target, int limit) {
        int size = nums.length;
        int res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int cost = canReplace(nums[i], nums[size-i-1], target, limit);
            if (cost == -1) return -1;
            res += cost;
        }
        return res;
    }
}
