package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Pair;

public class GraphUtils {

    public static final int INFINITY = (int) (1e9 + 7);

    @SuppressWarnings("unchecked")
    public static List<Integer>[] createAdjacencyList(int[][] edges, int vertices, boolean isDirected) {
        List<Integer>[] adj = new List[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            if (!isDirected) {
                adj[edge[1]].add(edge[0]);
            }
        }

        return adj;
    }

    @SuppressWarnings("unchecked")
    public static List<Pair<Integer, Integer>>[] createAdjacencyListWithEdgeWeights(int[][] edges, int vertices,
            boolean isDirected) {
        List<Pair<Integer, Integer>>[] adj = new List[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(new Pair<>(edge[1], edge[2]));
            if (!isDirected) {
                adj[edge[1]].add(new Pair<>(edge[0], edge[2]));
            }
        }

        return adj;
    }

    public static int[] convertListToArray(List<Integer> li) {
        int[] ansArray = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            ansArray[i] = li.get(i);
        }
        return ansArray;
    }

    public static int[][] createAdjacenyMatrix(int[][] edges, int vertices, boolean isDirected) {
        int[][] adj = new int[vertices][vertices];
        for (int[] edge : edges) {
            int wt = edge.length == 3 ? edge[2] : 1;
            adj[edge[0]][edge[1]] = wt;
            if (!isDirected) {
                adj[edge[1]][edge[0]] = wt;
            }
        }
        return adj;
    }

    /**
     * 
     * @param edges      edges array
     * @param vertices   number of vertices
     * @param isDirected is graph directed
     * @return int[][] distance matrix
     * 
     *         find the distance matrix from the edges array
     *         and assigns infinity to all other edges and 0 to the diagonal
     * 
     */
    public static int[][] createDistanceMatrix(int[][] edges, int vertices, boolean isDirected) {
        int[][] adj = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adj[i], INFINITY);
            adj[i][i] = 0;
        }

        for (int[] edge : edges) {
            int wt = edge.length == 3 ? edge[2] : 1;
            adj[edge[0]][edge[1]] = wt;
            if (!isDirected) {
                adj[edge[1]][edge[0]] = wt;
            }
        }
        return adj;
    }

}
