package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];

        int i = low, j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
            }

        }

        swap(arr, low, j);

        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }

    }

    public static void main(String[] args) {

        int[] arr = { 5, 4, -2, 10, 9, 9, 1, -7, 4 };

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

}
