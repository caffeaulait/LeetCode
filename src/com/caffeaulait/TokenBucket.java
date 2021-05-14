package com.caffeaulait;

public class TokenBucket {

    private static final int MAX_SIZE = 100;

    private static final int RATE = 1;

    private static long timestamp = getCurrentTime();

    private static int tokens = 0;

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static boolean getToken() {
        //记录来拿令牌的时间
        long now = getCurrentTime();
        //添加令牌
        tokens += (now - timestamp) * RATE;
        tokens = Math.min(MAX_SIZE, tokens);
        // 修改时间
        timestamp = now;
        if (tokens >= 1) {
            tokens--;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            if (i == 10) {
                Thread.sleep(500);
            }
            System.out.println("第" + i + "次请求结果 = " + getToken() + " 剩余token" +
                    ":" + tokens);
        }
    }
}
