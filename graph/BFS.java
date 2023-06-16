package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void bfs(int ind, List<Integer>[] adj, boolean vis[], List<Integer> li) {
        Queue<Integer> q = new LinkedList<>();

        q.add(ind);

        while (!q.isEmpty()) {
            int node = q.poll();
            li.add(node);

            for (int adjNode : adj[node]) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
    }

    public int[] bfsCall(int[][] edges, int vertices, boolean isDirected) {
        List<Integer> ans = new ArrayList<>();

        boolean vis[] = new boolean[vertices];
        Arrays.fill(vis, false);

        List<Integer>[] adj = GraphUtils.createAdjacencyList(edges, vertices, isDirected);

        System.out.println(Arrays.toString(adj));
        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                bfs(i, adj, vis, ans);
        }
        return GraphUtils.convertListToArray(ans);
    }

}
