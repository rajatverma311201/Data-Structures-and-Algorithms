package recursion;

import java.util.ArrayList;

/**
 * Subsequence
 */
public class Subsequence {

    public static void recursionPrint(int[] arr, int idx, ArrayList<Integer> li) {

        if (idx == arr.length) {
            System.out.println(li);
            return;
        }

        li.add(arr[idx]);

        recursionPrint(arr, idx + 1, li);

        li.remove(li.size() - 1);

        recursionPrint(arr, idx + 1, li);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        recursionPrint(arr, 0, new ArrayList<>());

    }
}