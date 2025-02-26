# Day 7

[question](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description)

The idea is to keep track of the length of strictly increasing and strictly decreasing subarray until index i.
If the definition of strictly increasing or strictly decreasing is not met, then we reset the 
corresponding length to 1, indicating i is the start of a new potential subarray.
