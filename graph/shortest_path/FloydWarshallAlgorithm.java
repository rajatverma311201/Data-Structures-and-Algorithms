package graph.shortest_path;

import graph.GraphUtils;

/**
 * 
 * MULTIPLE SOURCE SHORTEST PATH ALGORITHM
 * ALL Source SHORTEST PATH ALGORITHM
 * 
 * DYNAMIC PROGRAMMING
 * 
 * Floyd Warshall Algorithm
 * 
 * DETECTs NEGATIVE CYCLES
 * 
 * Time Complexity: O(V^3)
 * 
 * 
 * Matrix at position (i,j) represents the shortest distance from i to j
 * 
 */

public class FloydWarshallAlgorithm {

    static int INF = GraphUtils.INFINITY;

    /**
     * 
     * @param edges      edges array
     * @param vertices   number of vertices
     * @param isDirected is directed graph
     * @return int[][] distance matrix and an empty 2d (0x0) array if negative cycle
     *         is detected
     * 
     */

    public int[][] FloydWarshall(int[][] edges, int vertices, boolean isDirected) {

        int[][] dist = GraphUtils.createDistanceMatrix(edges, vertices, isDirected);
        for (int via = 0; via < vertices; via++) {
            for (int r = 0; r < vertices; r++) {
                for (int c = 0; c < vertices; c++) {
                    if (dist[r][via] == INF || dist[via][c] == INF) {
                        continue;
                    }
                    dist[r][c] = Math.min(dist[r][c], dist[r][via] + dist[via][c]);
                }
            }
        }

        // CHECKING FOR NEGATIVE CYCLE

        for (int i = 0; i < vertices; i++) {
            if (dist[i][i] < 0) {
                return new int[][] {};
            }
        }

        return dist;

    }

}
