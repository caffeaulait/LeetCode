package com.caffeaulait;

public class _0038_CountAndSay {
    /**
     *
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            char ch = prev.charAt(i);
            int count = 0;
            while (i + count <prev.length() && prev.charAt(i+count) == ch) count++;
            sb.append(count);
            sb.append(ch);
            i+=count;
        }
        return sb.toString();
    }
}
