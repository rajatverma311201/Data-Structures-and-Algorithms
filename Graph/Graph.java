package graph;

import java.util.Arrays;

public class Graph {

    public static void main(String[] args) {
        // TopologicalSortDFS topoDFS = new TopologicalSortDFS();
        // TopologicalSortBFS topoBFS = new TopologicalSortBFS();

        DFS dfs = new DFS();
        BFS bfs = new BFS();
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 1, 4 },
                { 2, 3 },
                { 2, 5 },
                { 3, 4 },
                { 3, 5 },
        };
        int vertices = 6;

        // int[] ans1 = topoDFS.topoSort(edges, 6);
        // int[] ans2 = topoBFS.topoSort(edges, 6);
        // System.out.println("DFS TOPO" + Arrays.toString(ans1));
        // System.out.println("BFS TOPO" + Arrays.toString(ans2));
        System.out.println(Arrays.toString(dfs.dfsCall(edges, vertices, false)));
        System.out.println(Arrays.toString(bfs.bfsCall(edges, vertices, false)));

    }
}