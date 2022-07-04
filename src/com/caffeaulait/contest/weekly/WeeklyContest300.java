package com.caffeaulait.contest.weekly;

import com.caffeaulait.struct.ListNode;

import java.util.*;

public class WeeklyContest300 {
    /**
     *
     */
    public String decodeMessage(String key, String message) {
        char c = 'a';
        Map<Character, Character> map = new HashMap<>();
        for (char k : key.toCharArray()) {
            if (map.containsKey(k) || k == ' ') continue;
            map.put(k, c);
            c++;
        }
        StringBuilder sb = new StringBuilder();
        for (char k : message.toCharArray()) {
            if (map.containsKey(k)) {
                k = map.get(k);
            }
            sb.append(k);
        }
        return sb.toString();
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int rowt = 0, rowb = m-1;
        int coll= 0, colr = n-1;
        int[][]matrix = new int[m][n];
        for (int[] ma : matrix) {
            Arrays.fill(ma, -1);
        }
        ListNode curr = head;
        while (curr != null) {
            for (int j = coll; j<= colr && curr != null; j++) {
                matrix[rowt][j] = curr.val;
                curr = curr.next;
            }
            for (int i = rowt+1;i<=rowb && curr != null; i++){
                matrix[i][colr] = curr.val;
                curr = curr.next;
            }
            for (int j = colr-1; j>=coll && curr != null;j--){
                matrix[rowb][j] = curr.val;
                curr = curr.next;
            }
            for (int i = rowb-1;i>=rowt+1 && curr != null;i--){
                matrix[i][coll] = curr.val;
                curr = curr.next;
            }
            rowt++;
            rowb--;
            coll++;
            colr--;
        }
        return matrix;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        return 0;
    }
}
