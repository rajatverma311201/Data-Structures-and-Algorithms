package sorting;

/**
 * 
 * Bubble Sort
 * 
 * 
 * Comparison based Sort
 * 
 * stable sort
 * 
 * In-place sort
 * 
 * Compares adjacent elements and swaps them if they are in wrong order.
 * 
 * Time Complexity : O(n^2)
 * 
 * 
 */

public class BubbleSort {

    public void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swapped = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!swapped)
                break;
        }
    }

}
