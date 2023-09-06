package dynamic_programming;

/**
 * We are given an array ‘ARR’ with N positive integers. We need to find if
 * there is a subset in “ARR” with a sum equal to K. If there is, return true
 * else return false.
 * 
 * 
 * 
 * https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
 * 
 * https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=1%3Fsource%3Dyoutube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 */

public class Q14_SubsetSumEqualsK {

    boolean subsetExistMemoCall(int[] nums, int ind, int target) {
        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return nums[ind] == target;
        }

        boolean notTake = subsetExist(nums, ind - 1, target);

        boolean take = false;

        if (nums[ind] <= target) {
            take = subsetExist(nums, ind - 1, target - nums[ind]);
        }

        return take || notTake;
    }

    boolean subsetExistMemo(int[] nums, int target) {
        return false;

    }

    boolean subsetExist(int[] nums, int ind, int target) {

        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return nums[ind] == target;
        }

        boolean notTake = subsetExist(nums, ind - 1, target);

        boolean take = false;

        if (nums[ind] <= target) {
            take = subsetExist(nums, ind - 1, target - nums[ind]);
        }

        return take || notTake;

    }

}
