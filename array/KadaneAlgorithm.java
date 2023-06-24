package array;

public class KadaneAlgorithm {


    /**
     * @param arr array of integers
     * @return maximum possible sub-array sum
     */
    public int maximumSum(int[] arr)
    {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num :arr)
        {
            currSum = currSum + num;
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum,  0);
        }

        return maxSum;

    }

}
