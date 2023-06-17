package graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    /**
     * Function to perform dfs on a graph
     * 
     * @param ind current node on which dfs called
     * @param adj adjacency list of graph
     * @param vis visited array for graph
     * @param st  stack to store the topo sort
     */
    public void dfsTopo(int ind, List<Integer>[] adj, boolean[] vis, Stack<Integer> st) {
        vis[ind] = true;
        for (int node : adj[ind]) {
            if (!vis[node]) {
                dfsTopo(node, adj, vis, st);
            }
        }
        st.push(ind);
    }

    /**
     * Function to find the topoSort, it calls the dfs function
     * 
     * @param edges    array of edges of graph in the form {u, v} indicating edge
     *                 from u to v (u->v)
     * @param vertices number of vertices for 0 based graph
     * @return array containing topological sort of the Directed Acyclic Graph
     */
    public int[] topoSort(int[][] edges, int vertices) {

        int[] ans = new int[vertices];

        Stack<Integer> st = new Stack<>();

        // ADJACENCY LIST
        List<Integer>[] adj = GraphUtils.createAdjacencyList(edges, vertices, true);

        boolean vis[] = new boolean[vertices];
        Arrays.fill(vis, false);

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                dfsTopo(i, adj, vis, st);
        }

        for (int i = 0; i < vertices; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }

}
