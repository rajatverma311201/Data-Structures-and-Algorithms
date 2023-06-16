package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public void dfs(int ind, List<Integer>[] adj, boolean[] vis, List<Integer> ans) {
        vis[ind] = true;
        ans.add(ind);

        for (int node : adj[ind]) {
            if (!vis[node]) {
                dfs(node, adj, vis, ans);
            }
        }
    }

    public int[] dfsCall(int[][] edges, int vertices, boolean isDirected) {
        List<Integer> ans = new ArrayList<>();

        boolean vis[] = new boolean[vertices];
        Arrays.fill(vis, false);

        List<Integer>[] adj = GraphUtils.createAdjacencyList(edges, vertices, isDirected);

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                dfs(i, adj, vis, ans);
        }
        return GraphUtils.convertListToArray(ans);
    }

}
