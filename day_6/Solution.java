class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        // only one pivot possible to satisfy ques criteria
        boolean pivotSeen = false;

        for (int i = 1; i < n; ++i) {
            if(nums[i-1] > nums[i]) {
                // 2nd potential pivot - breaks sorted ordering
                if(pivotSeen) return false;

                // a pivot is found
                pivotSeen = true;
            }
        }

        // no pivot found => no rotation happened and array is sorted
        // also validate the first and last elements
        return !pivotSeen || nums[0] >= nums[n-1];
    }
}
