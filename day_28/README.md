# Day 28

- [Leetcode question](https://leetcode.com/problems/most-profitable-path-in-a-tree/?envType=daily-question&envId=2025-02-24)

## Leetcode solution

Use the fact that bob doesn't have choices, he needs to reach the root node and there can be only one path to reach
the root node from any arbitrary node in the tree. Since a tree doesn't have cycles.

Build babs path and then explore all possible alice's paths.
