package month2.day_10;

import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    private static class Node {
        public long dist;
        public int node;

        public Node(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        public String toString() {
            return this.node + " " + this.dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<Node>> adjList = new HashMap<>();

        for(int[] road: roads) {
            int u = road[0], v = road[1], wt = road[2];

            if(!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
            if(!adjList.containsKey(v)) adjList.put(v, new ArrayList<>());

            adjList.get(u).add(new Node(wt, v));
            adjList.get(v).add(new Node(wt, u));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> (x.dist <= y.dist) ? -1 : 1);

        int[] number_paths = new int[n];
        long[] shortest_dist = new long[n];

        number_paths[0] = 1;
        Arrays.fill(shortest_dist, Long.MAX_VALUE);

        pq.add(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            for(Node nei: adjList.getOrDefault(tmp.node, new ArrayList<>())) {
                long newDist = tmp.dist + nei.dist;
                if(newDist < shortest_dist[nei.node]) {
                    shortest_dist[nei.node] = newDist;
                    number_paths[nei.node] = number_paths[tmp.node];
                    pq.add(new Node(shortest_dist[nei.node], nei.node));
                } else if(newDist == shortest_dist[nei.node]) {
                    number_paths[nei.node] = (number_paths[nei.node] + number_paths[tmp.node]) % MOD;
                }
            }
        }

        return number_paths[n-1];
    }
}
