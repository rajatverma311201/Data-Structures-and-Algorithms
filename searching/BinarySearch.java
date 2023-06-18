package searching;

/**
 * 
 * Binary Search
 * 
 * Pre-requisite : Array should be sorted
 * 
 * Divide and Conquer
 * 
 * 
 * Time Complexity : O(logn)
 * 
 * 
 * 
 */

public class BinarySearch {

    public int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

}
