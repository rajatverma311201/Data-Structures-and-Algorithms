package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Ninja is planing this ‘N’ days-long training schedule. Each day, he can
 * perform any one of these three activities. (Running, Fighting Practice or
 * Learning New Moves). Each activity has some merit points on each day. As
 * Ninja has to improve all his skills, he can’t do the same activity in two
 * consecutive days. Can you help Ninja find out the maximum merit points Ninja
 * can earn?
 * You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding
 * to each day and activity. Your task is to calculate the maximum number of
 * merit points that Ninja can earn.
 * 
 * https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
 * 
 */

public class Q7_NinjaTraining {

    // N*3 points matrix
    // (i, j) i denotes day and j denotes activity
    public int trainMaxMemo(int[][] points) {
        int[][] dp = new int[points.length][3 + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return trainMaxMemoCall(points, points.length - 1, 3, dp);
    }

    public int trainMaxMemoCall(int[][] points, int day, int lastActivity, int[][] dp) {
        if (day < 0) {
            return 0;
        }

        if (dp[day][lastActivity] != -1) {
            return dp[day][lastActivity];
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i == lastActivity) {
                continue;
            }

            int currDayPoint = points[day][i] + trainMaxMemoCall(points, day - 1, i, dp);
            ans = Math.max(ans, currDayPoint);
        }

        return dp[day][lastActivity] = ans;
    }

    // WORST SOLUTION
    // N*3 points matrix
    // (i, j) i denotes day and j denotes activity
    public int trainMaxRecur(int[][] points) {
        return trainMaxRecurCall(points, points.length - 1, -1);
    }

    public int trainMaxRecurCall(int[][] points, int day, int lastActivity) {
        if (day < 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i == lastActivity) {
                continue;
            }

            int currDayPoint = points[day][i] + trainMaxRecurCall(points, day - 1, i);
            ans = Math.max(ans, currDayPoint);
        }

        return ans;
    }
}
