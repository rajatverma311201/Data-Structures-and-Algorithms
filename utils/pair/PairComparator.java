package utils.pair;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.x > p2.x)
            return 1;
        if (p1.x == p2.x && p1.y > p2.y) {
            return 1;
        }
        return -1;

    }
}
