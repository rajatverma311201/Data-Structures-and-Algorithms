package graph.shortest_path;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import graph.GraphUtils;
import utils.Pair;

public class DijkstrasAlgorithm {

    public int minHeapComparator(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        if (a.first != b.first)
            return a.first - b.first;
        return a.second - b.second;
    }

    public void fnPriorityQueue() {

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(this::minHeapComparator);

    }

    public int[] findShortestPath(int[][] edges, int vertices, int source) {
        int[] ans = new int[vertices];
        List<Pair<Integer, Integer>>[] adj = GraphUtils.createAdjacencyListWithEdgeWeights(edges, vertices, false);
        int[] dist = new int[vertices];
        Arrays.fill(dist, (int) 1e9 + 7);

        dist[source] = 0;

        return ans;
    }

}