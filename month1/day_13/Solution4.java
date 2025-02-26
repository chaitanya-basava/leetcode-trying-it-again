class Solution4 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        long ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int goodPairs = m.getOrDefault(i - nums[i], 0);
            ans += i - goodPairs; // i is 0 indexed!, num of possible pairs - good pairs

            // putting after calculating ans to avoid counting (j, j) pair, i < j
            m.put(i - nums[i], m.getOrDefault(i - nums[i], 0) + 1);
        }

        return ans;
    }
}
