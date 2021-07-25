package com.caffeaulait.contest.biweekly;

public class BiWeeklyContest52 {

    public String sortSentence(String s) {
        if (s == null || s.length() == 0) return null;
        String[] strs = s.split(" ");
        String[] result = new String[strs.length];
        for (String str : strs) {
            int index = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
            result[index-1] = str.substring(0,str.length()-1);
        }
        return String.join(" ", result);
    }

    public int[] memLeak(int memory1, int memory2) {
        int second = 1;
        while (memory1 >= second || memory2 >= second) {
            if (memory1 >= memory2) {
                memory1 -= second;
            }else{
                memory2 -= second;
            }
            second++;
        }
        return new int[]{second, memory1, memory2};
    }

    public char[][] rotateTheBox(char[][] box) {
        for (char[] row : box) {
            fall(row);
        }
        return rotate(box);
    }

    public char[][] rotate(char[][] input) {
        int row = input.length;
        int col = input[0].length;
        char[][] output = new char[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                output[i][j] = input[row-j-1][i];
            }
        }
        return output;
    }

    public void fall(char[] row) {
        for (int i = row.length - 2; i >= 0; i--){
            int j = i;
            while ( j <= row.length -2 && row[j] == '#' && row[j + 1] == '.') {
                row[j] = '.';
                row[j+1] = '#';
                j++;
            }
        }
    }

    public int sumOfFlooredPairs(int[] nums) {
        long M = 1000000007;
        long sum = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++) {
                sum += (int)Math.floor(nums[i] / nums[j]);
            }
        }
        return (int) (sum % M);
    }
}
