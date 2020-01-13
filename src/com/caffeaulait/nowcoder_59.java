package com.caffeaulait;

public class nowcoder_59 {
    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
     * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */

    /**
     * 考虑到必然有一个点把绳子分成两份，两份各自分割得出的乘积最大值，组成整条绳子乘积的最大值。
     */
    public int cutRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int result = 0;
        for (int i = 4; i <=n; i++){
            for (int j = 1;j <=i/2; j++){
                result = Math.max(result,dp[j]*dp[i-j]);
            }
            dp[i] = result;
        }
        return dp[n];
    }
}
