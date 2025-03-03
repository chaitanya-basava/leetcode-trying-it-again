package month2.day_5;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] counts = new int[3];
        int[] ans = new int[n];

        for(int num: nums) {
            if(num < pivot) counts[0]++;
            else if(num == pivot) counts[1]++;
            else counts[2]++;
        }

        int s1 = 0, s2 = counts[0], s3 = counts[0] + counts[1];

        for(int num: nums) {
            if(num < pivot) {
                ans[s1++] = num;
            }
            else if(num == pivot) {
                ans[s2++] = num;
            }
            else {
                ans[s3++] = num;
            }
        }

        return ans;
    }
}
