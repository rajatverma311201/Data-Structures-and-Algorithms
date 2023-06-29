package array.stocks;

/**
 * 
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 * 
 * 
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 */

public class BuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[] change = new int[n - 1];

        for (int i = 1; i < n; i++) {
            change[i - 1] = prices[i] - prices[i - 1];
        }

        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            if (change[i] > 0) {
                sum = sum + change[i];
            }
        }
        return sum;

    }

}
