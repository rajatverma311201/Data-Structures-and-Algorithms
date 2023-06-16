package array;

import java.util.*;

import utils.pair.Pair;
import utils.pair.PairComparator;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        for (int i = 0; i < intervals.length; i++) {

            pq.add(new Pair(intervals[i][0], intervals[i][1]));

        }
        List<Pair> li = new ArrayList<Pair>();

        li.add(pq.poll());

        while (pq.size() > 0) {
            Pair currPair = pq.poll();
            Pair oldPair = li.get(li.size() - 1);

            if (oldPair.getY() >= currPair.getX()) {

                if (!(oldPair.getY() >= currPair.getY()))
                    oldPair.setY(currPair.getY());
                continue;
            }
            li.add(currPair);
        }

        int[][] ans = new int[li.size()][2];
        for (int i = 0; i < li.size(); i++) {
            ans[i][0] = li.get(i).getX();
            ans[i][1] = li.get(i).getY();
        }

        return ans;

    }

    public static void main(String[] args) {
        // int[][] intervals2 = {
        // { 1, 3 },
        // { 15, 18 },
        // { 8, 10 },
        // { 2, 4 },
        // { 9, 11 },
        // { 10, 11 },
        // { 2, 6 },
        // };

        int[][] intervals = { { 1, 4 }, { 2, 3 } };

        for (int[] row : merge(intervals))
            System.out.println(Arrays.toString(row));
    }
}
