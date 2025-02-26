# Day 16

- [Neetcode question](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [Neetcode solution](https://leetcode.com/problems/edit-distance/)
- [Neetcode question](https://leetcode.com/problems/minimum-window-substring/)
- [Leetcode question](https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/)

## Neetcode solution

2nd Ques:

at each index i, j 2 cases possible:
- equal characters → no edit needed at that index pair, `edit[i][j] = edit[i-1][j-1]`
- not equal characters -> 3 cases possible:
  1. insert a character after i -> `edit[i][j] = edit[i][j-1] + 1`
  2. delete a character at i -> `edit[i][j] = edit[i-1][j] + 1`
  3. replace a character at i and j -> `edit[i][j] = edit[i-1][j-1] + 1`

base conditions:
- if i == 0, then `edit[i][j] = j`, because we need to insert j characters
- if j == 0, then `edit[i][j] = i`, because we need to delete i characters to make the first string empty

3rd Ques:

Used a sliding window approach. In each iteration, check if the current substring has all chars from 2'nd string.
If it doesn't, then move right till it does. After that, check if the current substring has min length and update 
it if it does. Then move the left pointer.

## Leetcode solution

Use a priority queue to keep get the 2-min elements in the array. If at any point the min itself is `>= target`
or the size becomes < 2 we can stop.
