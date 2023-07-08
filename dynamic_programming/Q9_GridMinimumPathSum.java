package dynamic_programming;

import java.util.Arrays;

public class Q9_GridMinimumPathSum {

    public int getMinPathSumTab(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = mat[m][n];
                    continue;
                }

                int left = j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                int up = i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE;

                dp[i][j] = mat[i][j] + Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }

    public int getMinPathSumMemo(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinPathSumMemoCall(m - 1, n - 1, dp, mat);
    }

    public int getMinPathSumMemoCall(int m, int n, int[][] dp, int[][] mat) {
        if (m == 0 && n == 0) {
            return mat[0][0];
        }

        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int left = getMinPathSumMemoCall(m, n - 1, dp, mat);
        int up = getMinPathSumMemoCall(m - 1, n, dp, mat);

        return dp[m][n] = mat[m][n] + Math.min(left, up);
    }

}
