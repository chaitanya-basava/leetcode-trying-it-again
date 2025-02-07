class Solution1 {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> bColors = new HashMap<>();
        Map<Integer, Integer> cCounts = new HashMap<>();

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if(bColors.containsKey(query[0])) {
                cCounts.put(bColors.get(query[0]), cCounts.get(bColors.get(query[0]))-1);
                if(cCounts.get(bColors.get(query[0])) == 0) {
                    cCounts.remove(bColors.get(query[0]));
                }
            }
            bColors.put(query[0], query[1]);
            cCounts.put(query[1], cCounts.getOrDefault(query[1], 0) + 1);
            ans[i] = cCounts.size();
        }

        return ans;
    }
}