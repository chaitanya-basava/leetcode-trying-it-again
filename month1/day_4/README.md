# Day 4 (Jan 31, 2025)

[question](https://leetcode.com/problems/making-a-large-island/)

## Solution

It can be solved using BFS. Pre-compute the area of all the connected components present in the graph, annotate
each component with an id. Then iterate over all the 0's in the graph, and check the area of the 
connected components that can be formed by replacing it with 1.
Max of all possible areas is the answer.
