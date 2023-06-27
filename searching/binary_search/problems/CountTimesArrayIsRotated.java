package searching.binary_search.problems;

public class CountTimesArrayIsRotated {

    public int countTimes(int[] nums) {
        int idx = findMinimum(nums);

        return idx;
    }

    // UNIQUE ELEMENTS
    // returns minimum element index
    public int findMinimum(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int ans = 0;

        while (low <= high) {

            // if array is sorted already
            // then answer will be the min of ans and low

            if (nums[low] <= nums[high])

            {
                // ans = Math.min(ans, nums[low]);
                ans = nums[ans] < nums[low] ? ans : low;
                break;
            }

            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[mid]) {
                // ans = Math.min(ans, nums[low]);
                ans = nums[ans] < nums[low] ? ans : low;
                low = mid + 1;
            } else {
                // ans = Math.min(ans, nums[mid]);
                ans = nums[ans] < nums[mid] ? ans : mid;
                high = mid - 1;
            }
        }
        return ans;

    }

}
