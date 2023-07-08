package dynamic_programming;

import java.util.Arrays;

class Q8_GridUniquePaths {

    public int getNumberOfPathsTab(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                int up = i - 1 >= 0 ? dp[i - 1][j] : 0;

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public int getNumberOfPathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getNumberOfPathsMemoCall(m - 1, n - 1, dp);
    }

    public int getNumberOfPathsMemoCall(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int left = getNumberOfPathsMemoCall(m, n - 1, dp);
        int up = getNumberOfPathsMemoCall(m - 1, n, dp);

        return dp[m][n] = left + up;
    }

    public int getNumberOfPathsRecur(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m < 1 || n < 1) {
            return 0;
        }

        int left = getNumberOfPathsRecur(m, n - 1);
        int up = getNumberOfPathsRecur(m - 1, n);

        return left + up;
    }
}