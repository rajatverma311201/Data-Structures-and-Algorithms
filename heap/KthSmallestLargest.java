package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestLargest {

    public int kthSmallest(int[] arr, int k)
    {
        if(arr.length<k)
        {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x:arr)
        {
            pq.offer(x);
        }
        int i = 1;
        while (i < k)
        {
            i++;
            pq.poll();
        }

        return pq.peek();
    }



}
