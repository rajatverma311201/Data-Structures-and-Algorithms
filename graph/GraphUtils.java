package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

    @SuppressWarnings("unchecked")
    public static List<Integer>[] createAdjacencyList(int[][] edges, int vertices, boolean isDirected) {
        List<Integer>[] adj = new List[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            if (!isDirected) {
                adj[edge[1]].add(edge[0]);
            }
        }

        return adj;
    }

    public static int[] convertListToArray(List<Integer> li) {
        int[] ansArray = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            ansArray[i] = li.get(i);
        }
        return ansArray;
    }
}
