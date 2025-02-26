class Solution4 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num: nums) pq.add(num);
        int ans = 0;
        while(pq.size() > 1 && pq.peek() < k) {
            long a = pq.poll(); // this will be min amongst the 2
            long b = pq.poll(); // this will be max amongst the 2
            pq.add(2 * a + b);
            ans++;
        }

        return ans;
    }
}
