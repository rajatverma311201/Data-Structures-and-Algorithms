package dynamic_programming;

import java.util.Arrays;

public class Q1_FibonacciNumber {

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
    // Auxillary Stack Space

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

    // Worst Soln
    // O(2^n)
    public int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciIterative(n - 1) + fibonacciIterative(n - 2);
    }

}
