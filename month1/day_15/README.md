# Day 15

- [Neetcode question](https://leetcode.com/problems/word-search-ii/)
- [Neetcode question](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [Leetcode question](https://leetcode.com/problems/remove-all-occurrences-of-a-substring/)

## Neetcode solution

Ques 1:
Similar to yesterday's question, we would backtrack through the board to find the words. But calling dfs board scan
for each word makes it inefficient, so we precompute a trie and use that to look for all words within one board scan.

Ques 2:
Find the pivot and do binary search on one of the sides based on target value.

## Leetcode solution

Use a stack. There is a better approach using KMP algorithm, need to learn and implement this approach.
