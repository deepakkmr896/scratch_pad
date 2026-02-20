public class DSU_Pract {

    // rank
    int[] rank;
    int[] parent;
    DSU_Pract (int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    // findRoot
    public int findRoot(int element) {
        if (this.parent[element] == element) {
            return element;
        } else {
            // this is to update the root element to the current index, to make the fast retrieval going forward
            parent[element] = findRoot(this.parent[element]);
        }

        return parent[element];
    }

    // [0, 1, 2, 3, 4]
    // [1, 1, 1, 1, 1]
    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot == yRoot) {
            return;
        }

        if (this.rank[xRoot] < this.rank[yRoot]) {
            parent[xRoot] = parent[yRoot];
        } else if (this.rank[yRoot] < this.rank[xRoot]) {
            parent[yRoot] = parent[xRoot];
        } else {
            if (xRoot < yRoot) {
                parent[xRoot] = parent[yRoot];
                rank[yRoot]++;
            } else {
                parent[yRoot] = parent[xRoot];
                rank[xRoot]++;
            }
        }
    }
}
