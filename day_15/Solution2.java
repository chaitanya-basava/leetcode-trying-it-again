class Solution2 {
    private int binarySearch(int[] nums, int start, int end, int target) {
        int low = start, high = end, mid;

        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] < target) low = mid + 1;
            else if(nums[mid] > target) high = mid - 1;
            else return mid;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1, m;

        while(l < h) {
            m = l + (h - l) / 2;
            if(nums[0] <= nums[m]) l = m + 1;
            else {
                h = m;
            }
        }

        int pivot = (nums[0] < nums[nums.length-1]) ? 0 : h;

        if(target <= nums[nums.length-1])
            return binarySearch(nums, pivot, nums.length-1, target);

        return binarySearch(nums, 0, pivot-1, target);
    }
}