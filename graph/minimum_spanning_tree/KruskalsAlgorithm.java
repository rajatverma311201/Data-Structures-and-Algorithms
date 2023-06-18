package graph.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import graph.DisjointSet;
import utils.Pair;

public class KruskalsAlgorithm {

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

    public Pair<List<Pair<Integer, Integer>>, Integer> kruskals(int[][] adj, int vertices) {

        PriorityQueue<Edge> edges = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                edges.add(new Edge(i, adj[i][j], -1));
            }
        }
        DisjointSet ds = new DisjointSet(vertices);

        List<Pair<Integer, Integer>> mst = new ArrayList<>();

        int totalWeight = 0;

        while (!edges.isEmpty()) {
            Edge top = edges.poll();
            int node = top.node;
            int weight = top.weight;
            int parent = top.parent;

            if (ds.findMainParent(node) == ds.findMainParent(parent))
                continue;

            ds.unionByRank(node, parent);
            mst.add(new Pair<>(parent, node));
            totalWeight += weight;
        }

        return new Pair<>(mst, totalWeight);
    }

}
