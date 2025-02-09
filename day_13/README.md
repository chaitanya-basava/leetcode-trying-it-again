# Day 13

- [Neetcode question](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
- [Neetcode question](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
- [Neetcode question](https://leetcode.com/problems/same-tree/)
- [Leetcode question](https://leetcode.com/problems/count-number-of-bad-pairs/)

## Neetcode solution

1st sol:

Use zeroth index as the pivot, and then do binary search to find the minimum element.
In each iteration if mid is greater than pivot, then search in the right half,
else search in the left half with the mid stored as a potential answer.

Edge case: If the array is already sorted.

2nd sol:

Usual LCA, but use BST property to avoid traversing the whole tree. If both p and q are less than root, 
then no point traversing the right part and vice versa.
Not adding this condition won't affect the correctness of the solution, but it can make it faster.

3rd sol:

not needed

## Leetcode solution

We need to count all pairs such that `j - i != nums[j] - nums[i]` and `i < j`.
This can be rewritten as `j - nums[j] != i - nums[i]`.

If we get the count of all pairs that equal `j - nums[j]` till j (good pairs count), then we can subtract this
count from the total count of possible pairs with this j, we’re fixing the second index in the pair.
