
package sorting;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {

    public static void merge(int[] arr, int start, int mid, int end) {

        int sz = end - start + 1;

        int[] mergedArr = new int[sz];

        int i = start, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                mergedArr[k++] = arr[i++];
            } else if (arr[j] < arr[i]) {
                mergedArr[k++] = arr[j++];
            }
        }

        for (; j <= end; j++) {
            mergedArr[k++] = arr[j];
        }

        for (; i <= mid; i++) {
            mergedArr[k++] = arr[i];
        }

        for (int t = start; t <= end; t++) {
            arr[t] = mergedArr[t - start];
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, -2, 10, 9, 9, 1, -7, 4 };

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}