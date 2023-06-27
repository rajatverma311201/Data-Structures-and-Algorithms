package searching.binary_search.problems;

public class MinimumInRotatedSortedArray {

    public int findMinimum(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;

    }

}
