class Solution3 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for(int i = 0; i < n; i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, tIdx = 0;
        int mLen = Integer.MAX_VALUE;
        String ans = "";

        while(left < m) {
            while(tIdx < n) {
                if(right == m) break;
                char curr = s.charAt(right++);
                sCount.put(curr, sCount.getOrDefault(curr, 0) + 1);
                if(!tCount.containsKey(curr) || sCount.get(curr) > tCount.get(curr)) {
                    // this char not required, so don't increament tIdx
                    continue;
                }
                tIdx++;
            }

            if(tIdx == n && right - left < mLen) {
                ans = s.substring(left, right);
                mLen = right - left;
            }

            char curr = s.charAt(left++);
            int prev = sCount.get(curr);
            sCount.put(curr, prev - 1);
            if(!tCount.containsKey(curr) || prev > tCount.get(curr)) {
                // this char not required, so don't decrement tIdx
                continue;
            }
            if(right == m) break;
            tIdx--;
        }

        return ans;
    }
}