class Solution2 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            if('0' <= c && c <= '9') {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}