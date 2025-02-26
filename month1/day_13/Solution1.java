class Solution1 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, m;

        while(l < r) {
            m = l + (r - l) / 2;
            if(nums[0] <= nums[m]) l = m + 1;
            else r = m;
        }

        return nums[r] > nums[0] ? nums[0] : nums[r];
    }
}
