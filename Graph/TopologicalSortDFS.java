import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    public void dfs(int ind, List<Integer>[] adj, boolean[] vis, Stack<Integer> st) {
        vis[ind] = true;
        for (int node : adj[ind]) {
            if (!vis[node]) {
                dfs(node, adj, vis, st);
            }
        }
        st.push(ind);
    }

    @SuppressWarnings("unchecked")
    public int[] topoSort(int[][] edges, int vertices) {

        int[] ans = new int[vertices];

        Stack<Integer> st = new Stack<>();

        // ADJACENCY LIST
        List<Integer>[] adj = new ArrayList[vertices];

        boolean vis[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<Integer>();
            vis[i] = false;
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < vertices; i++) {
            if (!vis[i])
                dfs(i, adj, vis, st);
        }

        for (int i = 0; i < vertices; i++) {
            ans[i] = st.pop();

        }

        return ans;
    }

}
