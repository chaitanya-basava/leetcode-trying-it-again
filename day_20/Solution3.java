class Solution3 {
    private boolean backtrack(int curr_idx, int n, boolean[] used, int[] ans) {
        if(curr_idx == 2 * n - 1) return true;

        // nothing to fill if already occupied
        if(ans[curr_idx] != 0) {
            return backtrack(curr_idx+1, n, used, ans);
        }

        // try filling in lexographic order
        for(int i = n; i > 0; i--) {
            if(used[i]) continue;
            used[i] = true;
            ans[curr_idx] = i;

            // place only one 1
            if(i == 1) {
                if(backtrack(curr_idx+1, n, used, ans)) return true;
            } else {
                int other_idx = curr_idx + i;
                // check 2nd index validity
                if(other_idx < 2 * n - 1 && ans[other_idx] == 0) {
                    ans[other_idx] = i;
                    if(backtrack(curr_idx+1, n, used, ans)) return true;
                    ans[other_idx] = 0;
                }
            }

            ans[curr_idx] = 0;
            used[i] = false;
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        backtrack(0, n, used, ans);

        return ans;
    }
}
