class Solution1 {
    private int digitSum(int num) {
        int ans = 0;
        while(num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> sums = new HashMap<>();
        int ans = -1;
        for(int num: nums) {
            int dS = digitSum(num);
            if(!sums.containsKey(dS)) {
                sums.put(dS, new PriorityQueue<>());
            }

            if(sums.get(dS).size() == 2) {
                if(sums.get(dS).peek() >= num) continue;
                sums.get(dS).poll();
            }
            sums.get(dS).add(num);

            if(sums.get(dS).size() == 2) {
                int s = 0;
                for(int element: sums.get(dS)) {
                    s += element;
                }
                ans = Math.max(ans, s);
            }
        }

        return ans;
    }
}
