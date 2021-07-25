package com.caffeaulait.contest.biweekly;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class BiWeeklyContest26 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */
    public int maxPower(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int[] count = new int[26];
        count[s.charAt(0)-'a']++;
        int max = 0;
        for (int i = 1; i < s.length(); i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if (prev == curr || count[curr-'a']==0) {
                count[curr-'a']++;
            }
            else {
                max = Math.max(max, getMax(count));
                count[curr-'a']=1;
            }
        }
        max = Math.max(max, getMax(count));
        return max;
    }

    public int getMax(int[] arr){
        int max = 0;
        for (int num : arr) max = Math.max(max, num);
        return max;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) return result;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                if (gcd(i, j)!=1) continue;
                else result.add( j+"/"+i);
            }
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode curr, int max){
        if (curr == null) return;
        if (max == Integer.MIN_VALUE || curr.val >= max) {
            count++;
            max = curr.val;
        }
        dfs(curr.left, max);
        dfs(curr.right, max);
    }
}
