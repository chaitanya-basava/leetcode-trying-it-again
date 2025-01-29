# Day 2

[question](https://leetcode.com/problems/redundant-connection/)

### Solution
We can use Union-Find algorithm of disjoint sets to solve this problem.

### Union-Find Algorithm
Union operation: merges two distinct sets into one set.
Find operation: determines which set a particular element is in, each disjoint set has a representative.

If representative of two sets is same, then they are already connected and hence not disjointed.
The representative is always the root of the set, i.e., all nodes in a set will have the same root.

Useful to determine if two nodes in a graph are connected or not (directly via an edge or indirectly via a path).

```java
class UnionFind {
    int[] representative;
    int[] componentSize;
    int[] rank;

    // Number of distinct components in the graph - After merging the components using all the edges, we will
    // end up with the count of connected components (usually we get this using DFS)
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

        // the shorter component is added into the larger component
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
```

Create a class UnionFind, this will have the relevant data members and member functions to perform DSU operations:
1. `representative`: stores the immediate parent of nodes in the union find structure, initially each node will be its own representative.
2. `componentSize`: stores the number of nodes in the components with the node as the root node, initially the size of component for each node is 1. This is the rank.
3. `components`: stores the number of components in the graph, initially it will be equal to N as each node is considered a separate component.
4. `findRepresentative()`: returns the root node in the representative hierarchy.
5. `union()`: returns true after performing the union between the components of the two nodes that were not connected earlier.
   - If true is returned, that means that edge is needed as it is now connecting two disjoint graph components 
6. `isConnected()`: returns true if the graph is connected, i.e., components = 1 after covering all edges.

`time complexity`: 𝑂(𝛼(𝑁)) ≈ 𝑂(1), where 𝛼 is the inverse Ackermann function.
