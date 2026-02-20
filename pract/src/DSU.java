public class DSU {
    int [] parent;
    int[] rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /*
    n = 5
    parent = [0, 1, 2, 3, 4]
    rank = [1, 1, 1, 1, 1]

    union(0, 1)
    root -> 0, 1

    [1, 1, 2, 3, 4]
    [1, 2, 1, 1, 1]

    union(2, 3)
    [1, 1, 3, 3, 4]
    [1, 2, 1, 2, 1]

    union(1, 3)
    roots 1, 3

    [3, 3, 3, 3, 4]
    [1, 2, 1, 3, 1]

    find(0)

    0 != 3
    parent[0] = 3
    parent[1] = 3
    3 == 3

    return 3


    * */

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        }  else {
            if (parent[yRoot]  > parent[xRoot]) {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }
}
