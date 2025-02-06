# Day 10

- [Neetcode question](https://leetcode.com/problems/hand-of-straights/)
- [Leetcode question](https://leetcode.com/problems/tuple-with-same-product/)

## Neetcode Solution

No explanation needed, the code is self-explanatory. The idea is to start from a number and check if a group 
of consecutive numbers can be formed or not. The easiest way to get counts is to store in hashmap.
We can use TreeMap or HashMap + pq to solve this problem.

## Leetcode Solution

It's straightforward to solve once you identify the pattern of tuple counts. 
- If we have 2 pairs of numbers with the same product, then we can populate 1st element in 4 ways and 3rd element in 2 ways.
- If we have 3 pairs of numbers with the same product, then we can populate 1st element in 6 ways and 3rd element in 4 ways.
- If we have 4 pairs of numbers with the same product, then we can populate 1st element in 8 ways and 3rd element in 6 ways.

The 2nd and 4th positions can only be chosen in 1 way as there are no duplicates in input array.
If only 1 pair, then 0 tuples of size 4 can be formed.

=> if there are n pairs, then we can have 4 * n * (n - 1) tuples.

Populate the hashmap with product counts and then iterate over the hashmap to get the count of tuples.

O(n^2) time complexity and O(n) space complexity.
