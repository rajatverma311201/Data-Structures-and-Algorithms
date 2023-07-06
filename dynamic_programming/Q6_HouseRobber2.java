package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * 
 * MAXIMUM SUM OF NON ADJACENT ELEMENTS
 * first and last elements are also adjacent
 * 
 * 
 * HOUSE ROBBER 2
 * 
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * 
 * https://leetcode.com/problems/house-robber-ii/description/
 * 
 * https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/
 * 
 */
public class Q6_HouseRobber2 {

    public int giveMaxMoney(int[] nums) {
        int[] arrF = new int[nums.length - 1];
        int[] arrL = new int[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {

            if (i != 0) {
                arrL[i - 1] = nums[i];
            }

            if (i != nums.length - 1) {
                arrF[i] = nums[i];
            }

        }

        int takeFirst = giveMaxSumTabSpace(arrF);
        int takeLast = giveMaxSumTabSpace(arrL);
        return Math.max(takeFirst, takeLast);

    }

    // BEST SOLN
    // Time - O(n)
    // Space - O(1)
    public int giveMaxSumTabSpace(int[] arr) {
        int prev2 = 0;
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            int pick = arr[i] + ((i - 2) >= 0 ? prev2 : 0);
            int notPick = i - 1 >= 0 ? prev : 0;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public int giveMaxSumTab(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int pick = arr[i] + ((i - 2) >= 0 ? dp[i - 2] : 0);
            int notPick = i - 1 >= 0 ? dp[i - 1] : 0;
            dp[i] = Math.max(pick, notPick);
        }

        return dp[arr.length - 1];
    }

    // MEMOIZED SOLN
    // Auxillary Stack SPace
    public int giveMaxSumMemo(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return giveMaxSumMemoCall(arr, arr.length - 1, dp);
    }

    public int giveMaxSumMemoCall(int[] arr, int idx, int[] dp) {

        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = arr[idx] + giveMaxSumMemoCall(arr, idx - 2, dp);
        int notPick = 0 + giveMaxSumMemoCall(arr, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);

    }

}
