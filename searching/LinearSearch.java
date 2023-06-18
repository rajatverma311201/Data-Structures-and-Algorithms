package searching;

/**
 * 
 * Linear Search
 * 
 * Time Complexity : O(n)
 */
public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i])
                return i;
        }
        return -1;
    }
}
