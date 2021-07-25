package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0123_BestTimeToBuyAndSellStockIII {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     *
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     *              engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */

    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int min1 = prices[0];
        int min2 = prices[0];
        int profit1 = 0, profit2 = 0;
        for (int i = 1; i < prices.length;i++){
            min1 = Math.min(min1, prices[i]);
            profit1 = Math.max(profit1, prices[i]-min1);
            min2 = Math.min(min2, prices[i]-profit1);
            profit2 = Math.max(profit2, prices[i] - min2);
        }
        return profit2;
    }
}
