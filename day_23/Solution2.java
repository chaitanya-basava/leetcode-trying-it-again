class Solution2 {
    int comboCount;

    private String backtrack(int n, int k, String curr) {
        if(curr.length() == n) {
            comboCount++;
            if(k == comboCount) return curr;
            return "";
        }

        for(char i = 'a'; i <= 'c'; i++) {
            if(curr.length() > 0 && curr.charAt(curr.length()-1) == i) {
                continue;
            }

            String res = backtrack(n, k, curr + i);
            if(res != "") return res;
        }

        return "";
    }

    public String getHappyString(int n, int k) {
        this.comboCount = 0;
        return backtrack(n, k, "");
    }
}