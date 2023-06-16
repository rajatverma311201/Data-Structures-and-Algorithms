package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * TOPOLOGICAL SORT USING BFS
 * 
 * KAHN's Algorithm
 * 
 */

public class TopologicalSortBFS {

    public void bfs(int ind, List<Integer>[] adj, boolean vis[], int[] indegree, List<Integer> li) {
        Queue<Integer> q = new LinkedList<>();
        // q.offer(ind);

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;
            li.add(node);

            for (int adjNode : adj[node]) {
                if (!vis[adjNode]) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 0) {
                        q.offer(adjNode);
                    }
                }
            }
        }
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

        int[] indegree = new int[vertices];

        // ADJACENCY LIST
        // ArrayList<Integer>[] adj = new ArrayList<Integer>[vertices];
        List<Integer>[] adj = GraphUtils.createAdjacencyList(edges, vertices, true);

        List<Integer> li = new ArrayList<>();

        boolean vis[] = new boolean[vertices];
        Arrays.fill(vis, false);
        Arrays.fill(indegree, 0);

        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                bfs(i, adj, vis, indegree, li);
        }

        return GraphUtils.convertListToArray(li);
    }

}
