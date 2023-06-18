
package sorting;

/**
 * 
 * Insertion Sort
 * 
 * 
 * Comparison based Sort
 * 
 * Stable sort
 * 
 * In-place sort
 * 
 * 
 * Time Complexity : O(n^2)
 * 
 * 
 * 
 */

class InsertionSort {

    public void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

}