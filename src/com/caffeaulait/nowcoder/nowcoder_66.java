package com.caffeaulait.nowcoder;

public class nowcoder_66 {
    /**
     * 股票的最大利益
     * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
     */
    public int maxProfit(int[] prices){
        if (prices==null || prices.length==0)
            return 0;
        int minSoFar = prices[0];
        int profit = 0;
        for (int i =1;i<prices.length;i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            profit = Math.max(profit,prices[i]-minSoFar);
        }
        return profit;
    }
}
