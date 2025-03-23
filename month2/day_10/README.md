# Day 10

back after a 1-week break, I'm going to try to get back into the swing of things.

- [Leetcode](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/?envType=daily-question&envId=2025-03-23)

## Solution

This is a variation of shortest path problem, where we need to also store the number of possible shortest paths to a
node along with the shortest distance.
We can use Dijkstra's algorithm to solve this problem, with the modification to hold the path count.

Dijkstra's algorthm:

It uses a priority queue to store the nodes to be visited next, and the priority is the shortest distance to the node 
from src. We start by adding the src node to the priority queue with distance 0 and a path count 1.
Then we keep popping the node with the shortest distance from the priority queue. For each of its neighbors,
we update the distance if the new distance is smaller than the previous distance, and add to the priority queue.

```
pq.add(new Node(0, 0)); // pq holds the shortest distance from src to node

while(!pq.isEmpty()) {
    Node tmp = pq.poll();

    for(Node nei: adjList.getOrDefault(tmp.node, new ArrayList<>())) {
        long newDist = tmp.dist + nei.dist;
        if(newDist < shortest_dist[nei.node]) {
            shortest_dist[nei.node] = newDist;
            pq.add(new Node(shortest_dist[nei.node], nei.node));
        }
    }
}
```

This algo fails when dealing with graphs containing negative edge weights. Because it assumes that once a node is marked
as visited, its shortest path is finalized, which is incorrect with negative edges. 
