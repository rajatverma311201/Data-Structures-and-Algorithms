import java.util.ArrayList;
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

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
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
    @SuppressWarnings("unchecked")
    public int[] topoSort(int[][] edges, int vertices) {

        int[] indegree = new int[vertices];

        // ADJACENCY LIST
        List<Integer>[] adj = new ArrayList[vertices];
        List<Integer> li = new ArrayList<>();

        boolean vis[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<Integer>();
            vis[i] = false;
            indegree[i] = 0;
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                bfs(i, adj, vis, indegree, li);
        }
        int[] ans = new int[vertices];
        for (int i = 0; i < li.size(); i++) {
            ans[i] = li.get(i);
        }

        return ans;
    }

}
