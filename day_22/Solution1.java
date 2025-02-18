class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1, mid = 0;

        while(l <= r) {
            mid = l + (r - l) / 2;
            if(matrix[mid][n-1] < target) l = mid + 1;
            else if(matrix[mid][0] > target) r = mid - 1;
            else break; // target could be in the mid row, since matrix[mid][0] <= target <= matrix[mid][n-1]
        }

        if(l > r) return false;

        int searchRow = mid;
        l = 0;
        r = n - 1;

        while(l <= r) {
            mid = l + (r - l) / 2;
            if(matrix[searchRow][mid] < target) l = mid + 1;
            else if(matrix[searchRow][mid] > target) r = mid - 1;
            else return true;
        }

        return false;
    }
}