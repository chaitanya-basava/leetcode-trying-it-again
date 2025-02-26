class KthLargest {
    private int K;
    private Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        this.pq = new PriorityQueue<>(k);
        for(int i: nums) {
            if(this.pq.size() < k) this.pq.add(i);
            else {
                if(this.pq.peek() < i) {
                    this.pq.poll();
                    this.pq.add(i);
                }
            }
        }
    }

    public int add(int val) {
        this.pq.add(val);
        if(this.pq.size() > this.K) this.pq.poll();

        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */