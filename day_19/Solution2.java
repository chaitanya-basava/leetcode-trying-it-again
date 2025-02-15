class Solution {
    public boolean canPartition(int num, int target) {
        if (target < 0 || num < target) {
            return false;
        }

        if (num == target) {
            return true;
        }

        return (
                canPartition(num / 10, target - (num % 10)) ||
                        canPartition(num / 100, target - (num % 100)) ||
                        canPartition(num / 1000, target - (num % 1000))
        );
    }

    public int punishmentNumber(int n) {
        int ans = 0;

        for(int i = 1; i < n+1; i++) {
            if(canPartition(i*i, i)) ans += i * i;
        }

        return ans;
    }
}
