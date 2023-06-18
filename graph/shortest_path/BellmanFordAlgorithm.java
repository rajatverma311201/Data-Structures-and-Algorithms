package graph.shortest_path;

import java.util.Arrays;

/**
 * BELLMAN FORD ALGO helps in detecting negative cycles and Shortest path
 * calculation
 * 
 * Relax the edges N-1 times to get the shortest path from source to all other
 * nodes
 * 
 * Time complexity : O(V*E)
 * 
 * DO Nth Iteration for detecting Negative cycle
 * 
 */

public class BellmanFordAlgorithm {

    public int[] bellmanFord(int[][] edges, int vertices, int source) {

        int[] dist = new int[vertices];
        Arrays.fill(dist, (int) (1e9 + 7));

        dist[source] = 0;

        // RELAXING EDGES N-1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] == (int) (1e9 + 7))
                    continue;

                // RELAXING EDGES
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }

        }

        // CHECKING FOR NEGATIVE CYCLE
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] == (int) (1e9 + 7))
                continue;
            // RELAXING EDGES
            if (dist[u] + wt < dist[v]) {
                return new int[] {};
            }
        }
        return dist;

    }

}
