package com.caffeaulait;

public class BiWeeklyContest33 {
    /**
     * q1
     * q2
     * q3
     * q4
     */
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        int idx = 0;
        for (int i = str.length() - 1; i >= 0; i--){
            idx++;
            sb.append(str.charAt(i));
            if (idx % 3 == 0) {
                sb.append('.');
            }
        }
        if (idx % 3 == 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}
