class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, ans = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                // strctly decreasing
                dec++;
                inc = 1;
            } else if(nums[i-1] < nums[i]) {
                // strictly increasing
                inc++;
                dec = 1;
            } else {
                // neither strictly increasing nor strictly decreasing
                inc = 1;
                dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }
}
