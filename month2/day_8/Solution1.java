package month2.day_8;

class Solution1 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        boolean[] nums = new boolean[n*n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = grid[i][j] - 1;
                if(nums[num]) ans[0] = num + 1;
                nums[num] = true;
            }
        }

        for(int i = 0; i < n*n; i++) {
            if(!nums[i]) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
