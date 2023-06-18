package graph.shortest_path;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import graph.GraphUtils;
import utils.Pair;

/**
 * 
 * SINGLE SOURCE SHORTEST PATH ALGORITHM
 * 
 * Dijkstra's Algorithm
 * 
 * This does not work for negative weights cycle. (DIRECTED GRAPH)
 * This does not work for negative edge weights. (UNDIRECTED GRAPH)
 * 
 * 
 */

public class DijkstrasAlgorithm {

    int INF = GraphUtils.INFINITY;

    /**
     * Checks for the order of the pair in the priority queue.
     * based on the second value of the pair which is edge weight.
     * 
     * @param a first pair
     * @param b second pair
     * @return int
     */
    public int minHeapComparator(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        if (a.second != b.second)
            return a.second - b.second;
        return a.first - b.first;
    }

    /**
     * 
     * @param adj    adjacency list
     * @param dist   distance array
     * @param source source node
     */

    public void shortestPathUsingPriorityQueue(List<Pair<Integer, Integer>>[] adj, int[] dist, int source) {

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(this::minHeapComparator);

        pq.add(new Pair<>(source, dist[source]));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> top = pq.poll();
            int node = top.first;
            int dis = top.second;

            for (Pair<Integer, Integer> p : adj[node]) {
                int adjNode = p.first;
                int weight = p.second;

                // RELAXING EDGES
                if (dist[adjNode] > dis + weight) {
                    dist[adjNode] = dis + weight;
                    pq.add(new Pair<Integer, Integer>(adjNode, dist[adjNode]));
                }
            }
        }
    }

    /**
     * 
     * @param edges    edges array
     * @param vertices number of vertices
     * @param source   source node
     * @return int[] distance array
     */
    public int[] dijkstra(int[][] edges, int vertices, int source) {
        List<Pair<Integer, Integer>>[] adj = GraphUtils.createAdjacencyListWithEdgeWeights(edges, vertices, false);
        int[] dist = new int[vertices];
        Arrays.fill(dist, INF);

        dist[source] = 0;

        shortestPathUsingPriorityQueue(adj, dist, source);

        return dist;
    }

}