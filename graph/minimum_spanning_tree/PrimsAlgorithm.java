package graph.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import graph.GraphUtils;
import utils.Pair;

/**
 * 
 * MINIMUM SPANNING TREE
 * 
 * Prim's Algorithm
 * 
 * Weighted Undirected Graph
 * 
 * Time Complexity : O(ElogV)
 * 
 */

public class PrimsAlgorithm {

    /**
     * 
     * @param edges      adjacency list with edge weights
     * @param vertices   number of vertices
     * @param isDirected is graph directed
     * @return List of edges in the minimum spanning tree
     */

    // for storing in the priority queue.
    static class Edge {
        int node;
        int weight;
        int parent;

        Edge(int node, int weight, int parent) {
            this.node = node;
            this.weight = weight;
            this.parent = parent;
        }
    }

    /**
     * 
     * 
     * 
     * @param edges    edges array (u, v, wt)
     * @param vertices number of vertices
     * @return Pair
     *         first element is the list of edges in the minimum spanning tree
     *         second element is the total weight of the minimum spanning tree
     */

    public Pair<List<Pair<Integer, Integer>>, Integer> prims(int[][] edges, int vertices) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[vertices];
        List<Pair<Integer, Integer>>[] adj = GraphUtils.createAdjacencyListWithEdgeWeights(edges, vertices, false);

        List<Pair<Integer, Integer>> mst = new ArrayList<>();

        int totalWeight = 0;

        pq.offer(new Edge(0, 0, -1));

        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            int node = top.node;
            int weight = top.weight;
            int parent = top.parent;

            if (visited[node])
                continue;

            visited[node] = true;
            if (parent != -1) {
                mst.add(new Pair<>(parent, node));
                totalWeight += weight;
            }

            for (Pair<Integer, Integer> p : adj[node]) {
                int next = p.first;
                int nextWeight = p.second;
                if (!visited[next])
                    pq.offer(new Edge(next, nextWeight, node));
            }

        }

        return new Pair<>(mst, totalWeight);
    }

}
