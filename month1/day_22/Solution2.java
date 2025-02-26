class Solution2 {
    private boolean backtrack(int curr, String pattern, boolean[] used, int[] ans) {
        if(curr > 1) {
            char op = pattern.charAt(curr - 2);
            if((op == 'I' && ans[curr-2] > ans[curr-1]) || (op == 'D' && ans[curr-2] < ans[curr-1]))
                return false;
        }
        if(curr == pattern.length() + 1) return true;

        for(int i = 0; i < 9; i++) {
            if(used[i]) continue;
            used[i] = true;
            ans[curr] = i+1;
            if(backtrack(curr+1, pattern, used, ans)) return true;
            ans[curr] = 0;
            used[i] = false;
        }

        return false;
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        boolean[] used = new boolean[9];
        int[] ans = new int[n+1];
        backtrack(0, pattern, used, ans);

        StringBuilder sb = new StringBuilder();
        for(int num: ans) sb.append(num);
        return sb.toString();
    }
}