package dynamic_programming;

import java.util.Arrays;

public class Q4_KFrogJump {

    /**
     * 
     * 
     * There is a frog on the '1st' step of an 'N' stairs long staircase. The frog
     * wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th'
     * stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is
     * given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on
     * 'ith' staircase, he can jump either atmost k stairs.
     * Your task is to find the minimum total energy used by the frog to reach from
     * '1st' stair to 'Nth' stair.
     * 
     * 
     * 
     * https://atcoder.jp/contests/dp/tasks/dp_b
     * 
     * 
     * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
     * 
     */
    // BEST SOLN
    // O(n*k)
    // Space - O(n)
    // no auxillary stack space
    public int findMinEnergyTab(int[] heights, int k) {
        int[] dp = new int[heights.length];

        dp[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= k; i++) {
                if (i - j < 0)
                    break;
                int curr = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                ans = Math.min(ans, curr);
            }

            dp[i] = ans;
        }

        return dp[heights.length - 1];
    }

    // BEST SOLN
    // O(n*k)
    // Space - O(n)
    // O(n) auxillary stack space
    public int findMinEnergyMemo(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return findMinEnergyMemoCall(heights, heights.length - 1, k, dp);
    }

    public int findMinEnergyMemoCall(int[] heights, int ind, int k, int[] dp) {
        if (ind == 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (ind - i < 0)
                break;
            int curr = findMinEnergyMemoCall(heights, ind - i, k, dp) + Math.abs(heights[ind] - heights[ind - i]);
            ans = Math.min(ans, curr);
        }

        return dp[ind] = ans;
    }

    // WORST Soln
    public int findMinEnergyRecur(int[] heights, int ind, int k) {
        if (ind == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (ind - i < 0)
                break;

            int curr = findMinEnergyRecur(heights, ind - i, k) + Math.abs(heights[ind] - heights[ind - i]);
            ans = Math.min(ans, curr);
        }

        return ans;
    }

}
