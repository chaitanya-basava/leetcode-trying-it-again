class Solution2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n+1];
        int[] tmp = new int[n+1];

        for(int j = 0; j < n+1; j++) dp[j] = j; // need to add j chars, 1st string len = 0

        for(int i = 1; i < m+1; i++) {
            // dp -> i-1, tmp -> i
            tmp[0] = i; // delete i chars, 2nd string len = 0
            for(int j = 1; j < n+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) tmp[j] = dp[j-1];
                else {
                    tmp[j] = 1 + Math.min(tmp[j-1], Math.min(dp[j], dp[j-1]));
                }
            }
            for(int j = 0; j < n+1; j++) dp[j] = tmp[j];
        }

        return dp[n];
    }
}
