class Solution1 {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int[] idxs = new int[2];
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(count == 2) return false;
                idxs[count] = i;
                count++;
            }
        }
        if(count == 0) return true;
        if(count == 1 || s1.charAt(idxs[0]) != s2.charAt(idxs[1]) || s1.charAt(idxs[1]) != s2.charAt(idxs[0])) return false;
        return true;
    }
}