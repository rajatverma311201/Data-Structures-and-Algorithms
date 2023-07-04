package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * 
 * There is a frog on the '1st' step of an 'N' stairs long staircase. The frog
 * wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th'
 * stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is
 * given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on
 * 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
 * Your task is to find the minimum total energy used by the frog to reach from
 * '1st' stair to 'Nth' stair.
 * 
 * 
 * 
 * https://www.codingninjas.com/studio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 * 
 * 
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 * 
 */
public class Q3_FrogJump {

    // Space Optimized Soln
    // BEST SOLN
    // O(n)
    // Space - O(1)
    // no auxillary stack space

    public int findMinEnergyTabSpace(int[] heights) {

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < heights.length; i++) {
            int oneJump = prev + Math.abs(heights[i] - heights[i - 1]);
            int twoJump = Integer.MAX_VALUE;
            if (i >= 2) {
                twoJump = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(oneJump, twoJump);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    // BEST SOLN
    // O(n)
    // Space - O(n)
    // no auxillary stack space
    public int findMinEnergyTab(int[] heights) {
        int[] dp = new int[heights.length];

        dp[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            int oneJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoJump = Integer.MAX_VALUE;
            if (i >= 2) {
                twoJump = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(oneJump, twoJump);
        }

        return dp[heights.length - 1];
    }

    // BEST SOLN
    // O(n)
    // Space - O(n)
    // O(n) auxillary stack space
    public int findMinEnergyMemo(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return findMinEnergyMemoCall(heights, heights.length - 1, dp);
    }

    public int findMinEnergyMemoCall(int[] heights, int ind, int[] dp) {
        if (ind == 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int oneJump = findMinEnergyRecur(heights, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);

        int twoJump = Integer.MAX_VALUE;
        if (ind >= 2) {
            twoJump = findMinEnergyRecur(heights, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(oneJump, twoJump);
    }

    // WORST Soln
    public int findMinEnergyRecur(int[] heights, int ind) {
        if (ind == 0) {
            return 0;
        }

        int oneJump = findMinEnergyRecur(heights, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);

        int twoJump = Integer.MAX_VALUE;
        if (ind >= 2) {
            twoJump = findMinEnergyRecur(heights, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return Math.min(oneJump, twoJump);
    }

}
