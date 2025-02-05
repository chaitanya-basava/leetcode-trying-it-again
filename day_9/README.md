# Day 9

- [Leetcode question](https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal)
- [Neetcode question](https://leetcode.com/problems/combination-sum/)
- [TUF question](https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1)

## Leetcode Solution

Not needed

## Neetcode Solution

We have two possible choices at each index, consider the num at that point (if target is >= num) or not consider it.
Recurse for these two choices with a base condition of idx == n and add to answer if target == 0.
