package dynamic_programming;

import java.util.Arrays;

public class Q5_MaxSumOfNonAdjacentElements {

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

    // WORST SOLN
    public int giveMaxSumRecur(int[] arr) {
        return giveMaxSumRecurCall(arr, arr.length - 1);
    }

    public int giveMaxSumRecurCall(int[] arr, int idx) {

        if (idx < 0) {
            return 0;
        }

        int pick = arr[idx] + giveMaxSumRecurCall(arr, idx - 2);
        int notPick = 0 + giveMaxSumRecurCall(arr, idx - 1);

        return Math.max(pick, notPick);

    }

}
