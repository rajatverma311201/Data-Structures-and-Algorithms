public class DisjointSet {

    private int[] rank;
    private int[] parent;
    private int vertices;

    DisjointSet(int vertices) {
        this.vertices = vertices;
        rank = new int[this.vertices + 1];
        parent = new int[this.vertices + 1];

        for (int i = 0; i <= vertices; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int findMainParent(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        } else {
            // Path Compression
            return parent[vertex] = findMainParent(parent[vertex]);
        }
    }

    public void unionByRank(int u, int v) {
        int parentV = findMainParent(v);
        int parentU = findMainParent(u);

        if (parentU == parentV) {
            return;
        }

        if (rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        }

        else if (rank[parentV] < rank[parentU]) {
            parent[parentV] = parentU;
        }

        else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }

    public int getParentAtIndex(int index) {
        if (index > vertices) {
            return -1;
        }

        return this.parent[index];
    }

    public int getRankAtIndex(int index) {
        if (index > vertices) {
            return -1;
        }

        return this.rank[index];
    }

    public int getVertices() {
        return this.vertices;
    }

}
