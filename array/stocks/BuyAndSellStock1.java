package array.stocks;

/**
 * 
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 */

public class BuyAndSellStock1 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[] change = new int[n - 1];

        for (int i = 1; i < n; i++) {
            change[i - 1] = prices[i] - prices[i - 1];
        }

        int sum = 0;
        int currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum = currSum + change[i];

            if (currSum < 0)
                currSum = 0;

            sum = Math.max(sum, currSum);
        }
        return sum;

    }

}
