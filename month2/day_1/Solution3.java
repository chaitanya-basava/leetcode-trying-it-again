class Solution3 {

    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0, n = arr.length;
        Map<Integer, Integer> vals = new HashMap<>();

        // count of fibb seqs like - ...., arr[prev], arr[curr]
        int[][] dp = new int[n][n];

        for (int curr = 0; curr < n; curr++) {
            vals.put(arr[curr], curr);
            for (int prev = 0; prev < curr; prev++) {
                int diff = arr[curr] - arr[prev];
                int prevIdx = vals.getOrDefault(diff, -1);

                dp[prev][curr] = (diff < arr[prev] && prevIdx != -1) ? dp[prevIdx][prev] + 1 : 2;

                ans = Math.max(ans, dp[prev][curr]);
            }
        }

        return ans > 2 ? ans : 0;
    }
}
