package searching.binary_search.problems;


import java.util.Arrays;

/**
 *
 * AGGRESSIVE  COWS
 *
 *
 * https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
 *
 * https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
 *
 * https://practice.geeksforgeeks.org/problems/aggressive-cows/0
 *
 */
public class AggressiveCows {


    public int aggressiveCows(int[] stalls, int numCows)
    {
        Arrays.sort(stalls);

        int low = 1;
        int high =stalls[stalls.length-1] - stalls[0];

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(cowsCanBePlaced(stalls, numCows, mid))
            {
                low = mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return high;

    }


    private boolean cowsCanBePlaced(int[] stalls, int numCows, int minDist)
    {
        int lastStall = stalls[0];
        int cntCows = 1;

        for (int stall : stalls) {
            if (stall - lastStall >= minDist) {
                cntCows++;
                lastStall = stall;
            }
            if (cntCows >= numCows) {
                return true;
            }
        }

        return false;
    }




}
