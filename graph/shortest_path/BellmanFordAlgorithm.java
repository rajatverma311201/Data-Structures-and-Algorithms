package graph.shortest_path;

import java.util.Arrays;

import graph.GraphUtils;

/**
 * 
 * SINGLE SOURCE SHORTEST PATH ALGORITHM
 * 
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

    int INF = GraphUtils.INFINITY;

    /**
     * 
     * @param edges    edges array
     * @param vertices number of vertices
     * @param source   source node
     * @return int[] distance array, and an empty array if negative cycle is
     *         detected
     * 
     */

    public int[] bellmanFord(int[][] edges, int vertices, int source) {

        int[] dist = new int[vertices];
        Arrays.fill(dist, INF);

        dist[source] = 0;

        // RELAXING EDGES N-1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] == INF)
                    continue;

                // RELAXING EDGES
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }

        }

        // CHECKING FOR NEGATIVE CYCLE
        // BY RELAXING EDGES ONE MORE TIME(Nth TIME)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] == INF)
                continue;
            // RELAXING EDGES
            if (dist[u] + wt < dist[v]) {
                return new int[] {};
            }
        }
        return dist;

    }

}
