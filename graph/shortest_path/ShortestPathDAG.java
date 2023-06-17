package graph.shortest_path;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import graph.GraphUtils;
import utils.Pair;

/**
 * 
 * 
 * SHORTEST PATH CALCULATION USING DFS , TOPOLOGICAL SORTING
 * 
 * SINGLE SOURCE SHORTEST PATH
 * 
 * DIRECTED ACYCLIC GRAPH - ( DAG )
 * 
 */

public class ShortestPathDAG {

    /**
     * @param edges    list of edges with weight (u,v,w)
     * @param vertices total number of vertices
     * @param source   source vertex
     * @return array shortest path from source to all vertices
     * 
     */
    public int[] findShortestPath(int[][] edges, int vertices, int source) {

        int[] ans = new int[vertices];

        // will store the topo sort
        Stack<Integer> st = new Stack<>();

        // ADJACENCY LIST
        List<Pair<Integer, Integer>>[] adj = GraphUtils.createAdjacencyListWithEdgeWeights(edges, vertices, true);

        boolean vis[] = new boolean[vertices];
        Arrays.fill(vis, false);

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                dfsTopo(i, adj, vis, st);
        }

        return ans;
    }

    /**
     * Function to perform dfs on a graph
     * 
     * @param ind current node on which dfs called
     * @param adj adjacency list of graph
     * @param vis visited array for graph
     * @param st  stack to store the topo sort
     */
    public void dfsTopo(int ind, List<Pair<Integer, Integer>>[] adj, boolean[] vis, Stack<Integer> st) {
        vis[ind] = true;
        for (Pair<Integer, Integer> nodePair : adj[ind]) {
            if (!vis[nodePair.first]) {
                dfsTopo(nodePair.first, adj, vis, st);
            }
        }
        st.push(ind);
    }

}
