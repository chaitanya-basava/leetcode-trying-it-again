class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if(s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') return false;
        else st.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            char t = s.charAt(i);
            if(t == '}' || t == ']' || t == ')') {
                if(st.isEmpty()) return false;
                char s_t = st.pop();
                if((s_t == '{' && t != '}') || (s_t == '[' && t != ']') || (s_t == '(' && t != ')'))
                    return false;
            } else {
                st.push(t);
            }
        }

        return st.isEmpty();
    }
}
