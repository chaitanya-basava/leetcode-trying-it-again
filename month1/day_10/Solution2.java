class Solution2 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> prods = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int p = nums[i] * nums[j];
                prods.put(p, prods.getOrDefault(p, 0) + 1);
            }
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: prods.entrySet()) {
            int count = 2 * entry.getValue();
            ans += count * (count-2);
        }

        return ans;
    }
}
