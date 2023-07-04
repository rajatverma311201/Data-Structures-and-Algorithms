package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * 
 * You have been given a number of stairs. Initially, you are at the 0th stair,
 * and you need to reach the Nth stair. Each time you can either climb one step
 * or two steps. You are supposed to return the number of distinct ways in which
 * you can climb from the 0th step to Nth step.
 * 
 * 
 * 
 * 1D dp
 * 
 * https://www.codingninjas.com/studio/problems/count-ways-to-reach-nth-stairs_798650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 * 
 * 
 * SIMILAR AS A FIBONACCI NUMBER
 * 
 */
public class Q2_ClimbingStairs {

    // Best Soln Iterative
    // O(n)
    // No Extra Space - O(1)
    public int fibonacciIterative(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int t1 = 0, t2 = 1;
        for (int i = 2; i <= n; i++) {
            int tn = t1 + t2;
            t1 = t2;
            t2 = tn;
        }
        return t2;
    }

    // Best Soln Memoized
    // O(n)
    // Auxillary Stack Space (Recursion)

    public int fibMemoCall(int n, int[] dp) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibMemoCall(n - 1, dp) + fibMemoCall(n - 2, dp);

    }

    public int fibMemo(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return fibMemoCall(n, dp);

    }

}
