class Solution1 {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);

        for(int i = 0; i < points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                int c = Edge.distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                pq.add(new Edge(i, j, c));
            }
        }

        UnionFind u = new UnionFind(points.length);

        while(u.n > 1) {
            Edge edge = pq.poll();
            if(u.union(edge.i, edge.j)) cost += edge.cost;
        }

        return cost;
    }

    private class Edge {
        int i, j, cost;
        Edge(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        public static int distance(int i1, int j1, int i2, int j2) {
            return Math.abs(i2 - i1) + Math.abs(j2 - j1);
        }
    }

    private class UnionFind {
        int n;
        int[] rank, root;

        UnionFind(int n) {
            this.n = n;
            this.rank = new int[n];
            this.root = new int[n];

            for(int i = 0; i < n; i++) {
                this.rank[i] = 1;
                this.root[i] = i;
            }
        }

        boolean union(int x, int y) {
            x = this.find(x);
            y = this.find(y);

            if(x == y) return false;

            if(this.rank[x] >= this.rank[y]) {
                if(this.rank[x] == this.rank[y]) this.rank[x]++;
                this.root[y] = x;
            } else {
                this.root[x] = y;
            }
            this.n--;

            return true;
        }

        int find(int x) {
            if(x == this.root[x]) return x;
            return this.root[x] = this.find(this.root[x]);
        }
    }
}
