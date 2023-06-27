package searching.binary_search.problems;

public class SearchInRotatedSortedArray {

    /**
     * 
     * ELEMENTS ARE UNIQUE
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchType1(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // LEFT HALF SORTED

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // RIGHT HALF SORTED
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 
     * ELEMENTS ARE NOT UNIQUE
     * ELEMENTS ARE REPEATING
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchType2(int[] nums, int target) {
        return -1;
    }

}
