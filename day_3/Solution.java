import java.util.*;

class Solution {
    private static class Res {
        Map<Integer, Integer> dist;
        Integer group;

        Res(Map<Integer, Integer> dist, Integer group) {
            this.dist = dist;
            this.group = group;
        }
    }

    private static class Pair {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    private Res bfs_longest_path(int src,
                                 Map<Integer, List<Integer>> adj,
                                 Set<Integer> visited) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        q.add(new Pair(src, 1)); // src, distance from src (1-indexed)
        dist.put(src, 1);
        int maxGroups = 1;

        while(!q.isEmpty()) {
            Pair p = q.remove();
            if(!adj.containsKey(p.f)) continue;
            for(int nei: adj.get(p.f)) {
                if(dist.containsKey(nei)) {
                    if(dist.get(nei) == p.s) {
                        // odd length cycle exists - bipartite check
                        return new Res(null, -1);
                    }
                    continue;
                }
                q.add(new Pair(nei, p.s + 1));
                dist.put(nei, p.s + 1);
                maxGroups = p.s + 1;
                visited.add(nei);
            }
        }

        return new Res(dist, maxGroups);
    }

    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge: edges) {
            if(!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<>());
            }

            if(!adj.containsKey(edge[1])) {
                adj.put(edge[1], new ArrayList<>());
            }

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int ans = 0;

        for(int i = 1; i < n + 1; i++) {
            if(visited.contains(i)) continue;

            visited.add(i);
            // get nodes in a connected component
            Res res = bfs_longest_path(i, adj, visited);
            if(res.group == -1) return -1;

            // do bfs from each node in the connected component
            int max_count = 0;
            for(int src: res.dist.keySet()) {
                Res res1 = bfs_longest_path(src, adj, visited);
                max_count = Math.max(max_count, res1.group);
            }

            ans += max_count;
        }

        return ans;
    }
}
