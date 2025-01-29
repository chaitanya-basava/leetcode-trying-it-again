class Solution {
    private static class UnionFind {
        int[] representative;
        int[] componentSize;
        int[] rank;
        // Number of distinct components in the graph. - after merging the components using all the edges, we will end up with the count of connected components (usually we get this using DFS)
        int components;

        // Initialize the list representative and componentSize
        // initially each node is representative of itself with size 1.
        public UnionFind(int n) {
            components = n;
            representative = new int[n + 1];
            componentSize = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                rank[i] = 1;
                representative[i] = i;
                componentSize[i] = 1;
            }
        }

        // Get the root of a node.
        int findRepresentative(int x) {
            if (representative[x] == x) {
                return x;
            }

            // Path compression.
            return representative[x] = findRepresentative(representative[x]);
        }

        boolean union(int x, int y) {
            x = findRepresentative(x);
            y = findRepresentative(y);

            // vertices already connected
            if (x == y) {
                return false;
            }

            // shorter component is added into the larger component
            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representative[x] = y;
            }

            components--;
            return true;
        }


        boolean connected(int x, int y) {
            return findRepresentative(x) == findRepresentative(y);
        }

        // Returns true if all nodes get merged to one.
        boolean isGraphConnected() {
            return components == 1;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges) {
            if(!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[] {0, 0};
    }
}