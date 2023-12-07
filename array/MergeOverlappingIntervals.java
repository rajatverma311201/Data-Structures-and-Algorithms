package array;

import java.util.*;

import utils.Pair;

public class MergeOverlappingIntervals {

    private static int minHeapComparator(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        if (!Objects.equals(a.first, b.first))
            return a.first - b.first;
        return a.second - b.second;
    }

    public static int[][] merge(int[][] intervals) {

        // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new
        // PairComparator<Integer, Integer>());
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(MergeOverlappingIntervals::minHeapComparator);

        for (int[] interval : intervals) {
            pq.add(new Pair<>(interval[0], interval[1]));
        }
        List<Pair<Integer, Integer>> li = new ArrayList<>();

        li.add(pq.poll());

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> currPair = pq.poll();
            Pair<Integer, Integer> oldPair = li.get(li.size() - 1);

            if (oldPair.second >= currPair.first) {
                if (!(oldPair.second >= currPair.second))
                    oldPair.second = currPair.second;
                continue;
            }
            li.add(currPair);
        }

        int[][] ans = new int[li.size()][2];
        for (int i = 0; i < li.size(); i++) {
            ans[i][0] = li.get(i).first;
            ans[i][1] = li.get(i).second;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] intervals2 = {
                { 1, 3 },
                { 15, 18 },
                { 8, 10 },
                { 2, 4 },
                { 9, 11 },
                { 10, 11 },
                { 2, 6 },
        };

        // int[][] intervals = { { 1, 4 }, { 2, 3 } };

        for (int[] row : merge(intervals2))
            System.out.println(Arrays.toString(row));
    }
}
