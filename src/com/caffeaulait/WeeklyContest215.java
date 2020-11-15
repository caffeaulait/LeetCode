package com.caffeaulait;

import java.util.*;

public class WeeklyContest215 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */
    class Pair {
        int key;
        String value;
        public Pair(int k, String v){
            key = k;
            value = v;
        }
    }

    class OrderedStream {
        List<Pair> list;
        int ptr;
        public OrderedStream(int n) {
           list  = new ArrayList<>();
           for (int i = 0; i < n; i++) list.add(null);
           ptr = 1;
        }

        public List<String> insert(int id, String value) {
            List<String> res = new ArrayList<>();
            list.set(id-1, new Pair(id, value));
            if (ptr == id) {
                for (int i = ptr-1; i < list.size(); i++){
                    if (list.get(i) != null) {
                        res.add(list.get(i).value);
                        ptr++;
                    }
                    else {
                        break;
                    }
                }
            }
            return res;
        }
    }

    public boolean closeStrings(String word1, String word2) {
        int[] arr = new int[26];
        for (char c : word1.toCharArray()){
            arr[c-'a']++;
        }
        for (char s : word2.toCharArray()){
            arr[s-'a']--;
        }
        System.out.println(Arrays.toString(arr));
        int nonZeros = 0;
        int fst = 0;
        int snd = 0;
        for (int j : arr) {
            if (j != 0) nonZeros++;
            if (nonZeros == 1) fst = j;
            if (nonZeros == 2) snd = j;
            if (nonZeros > 2) return false;
        }
        System.out.printf("first and second are %d, %d", fst, snd);
        if (nonZeros == 0) return true;
        return fst + snd == 0;
    }

    List<Integer> res = new ArrayList<>();

    public int minOperations(int[] nums, int x) {
        backTrack(nums, x, 0, nums.length - 1, 0);
        if (res.size() == 0) return -1;
        Collections.sort(res);
        return res.get(0);
    }

    private void backTrack(int[] nums, int target, int i, int j, int step){
        if (target == 0) {
            res.add(step);
        }else {
            if ( i > j) return;
            backTrack(nums, target - nums[i], i + 1, j, step + 1);
            backTrack(nums, target - nums[j], i, j - 1, step + 1);
        }
    }

}
