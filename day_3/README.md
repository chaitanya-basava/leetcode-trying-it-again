# Day 3

[question](https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/)

## Solution

The Idea is to brute force yourself into doing bfs from each node and see how many groups can be formed.
Max of these groups is the answer.

Important thing to see in this is that the graph can be disconnected. So, the steps are as follows:
- Get each connected component
- Run BFS from each node in each component and get max number of groups possible for each component
- Add the max group count from each component and return the answer.

A graph with odd length cycle can't be divided into groups that satisfy the question.
Which implies if the graph is not bipartite, then it can't be divided into groups that satisfy the question.

odd length cycle => non bipartite graph

Watch neetcode's [video](https://www.youtube.com/watch?v=Gn0ADjje8Rg) to understand the intuition better.

## Bipartite Graph
A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color.
This means we can divide the graph’s vertices into two distinct sets where:

- All edges connect vertices from one set to vertices in the other set.
- No edges exist between vertices within the same set.

A bipartite graph can't contain any odd-length cycles, as this would require vertices from the same set to
be connected by an edge.

The existence of an odd length cycle can be determined using bfs (see code).
If the distance of a neighbor from the source is equal to the distance of the current node from the source, then it is an odd length cycle.
As one edge would be connecting the neighbor and the current node ⇒ cycle length = 2 * length + 1 (odd).

There is also a coloring-based approach with BFS, where we assign alternating colors for a node and its neighbors.
If at any point, the color of the current node and neighbor is the same, then it is not bipartite.

Revisit this - [bipartite graph](https://www.geeksforgeeks.org/what-is-bipartite-graph/)
