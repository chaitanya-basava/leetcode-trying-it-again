class Solution {
    public int maxAscendingSum(int[] nums) {
        int _sum = nums[0], ans = _sum;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] >= nums[i]) _sum = 0;

            _sum += nums[i];
            ans = Math.max(ans, _sum);
        }

        return ans;
    }
}