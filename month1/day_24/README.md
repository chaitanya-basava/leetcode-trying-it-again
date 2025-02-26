# Day 24

- [Neetcode question](https://leetcode.com/problems/detect-squares/)
- [Neetcode question](https://leetcode.com/problems/clone-graph/)
- [Leetcode question](https://leetcode.com/problems/find-unique-binary-string/?envType=daily-question&envId=2025-02-20)

## LeetCode Solution

Found an even better solution. Two binary strings are different as long as they differ by at least one character.
We can construct the ans by using fact.

```java
class Solution3 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0'); // intentionally flip the bit at i
            // this ensures at least the ans is different from the i'th string
            // at the end we have an ans which differs from all the strings
        }
        return ans.toString();
    }
}
```
