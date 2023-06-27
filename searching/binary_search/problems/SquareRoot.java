package searching.binary_search.problems;

/**
 *
 * 
 * floor value of square root of number num
 * find max integer m such that m*m <= num
 *
 */

public class SquareRoot {

    public int squareRootFloor(int num) {
        int low = 1, high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == num)
                return mid;
            else if (mid * mid < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }

}
