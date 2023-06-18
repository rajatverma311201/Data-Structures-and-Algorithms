package sorting;

/**
 * 
 * Selection Sort
 * 
 * 
 * Comparison based Sort
 * 
 * Unstable sort
 * 
 * In-place sort
 * 
 * 
 * Time Complexity : O(n^2)
 * 
 * 
 * 
 */

public class SelectionSort {

    public void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex == i)
                continue;
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

}
