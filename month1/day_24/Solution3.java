class Solution3 {
    private String backtrack(int[] nums, String curr, int n) {
        if(curr.length() == n) {
            int currNum = Integer.parseInt(curr, 2);
            for(int num: nums) {
                if(num == currNum) return "";
            }
            return curr;
        }

        String l = backtrack(nums, curr + "0", n);
        if(l != "") return l;

        String r = backtrack(nums, curr + "1", n);
        return r;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] converted = new int[n];

        for(int i = 0; i < n; i++) {
            converted[i] = Integer.parseInt(nums[i], 2);
        }

        return backtrack(converted, "", n);
    }
}
