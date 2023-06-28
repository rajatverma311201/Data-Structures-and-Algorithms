package array;

import java.util.Arrays;

public class NextPermutation {

    // {2, 1, 5, 4, 3, 0, 0}
    // ans - {2, 3, 0, 0, 1, 4, 5}

    public int[] getNext(int[] arr) {
        int idx = -1;

        int[] nums = Arrays.copyOf(arr, arr.length);

        int n = nums.length;

        // find breakpoint
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        // if array is descending that means the
        // sort the array in ascending and return
        if (idx == -1) {
            Arrays.sort(nums);
            return nums;
        }

        // get the just next greater element than the number
        // at the breakpoint, iterate from last and the first
        // one greater will be the required

        // then swap the two numbers
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }

        // SORT THE array after the breakpoint index and return it
        Arrays.sort(nums, idx + 1, nums.length);

        return nums;

    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();

        int[] nextArr = obj.getNext(new int[] { 2, 1, 5, 4, 3, 0, 0 });

        // {2, 3, 0, 0, 1, 4, 5}
        System.out.println(Arrays.toString(nextArr));
    }
}
