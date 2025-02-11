class Solution3 {

    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            stk.push(s.charAt(index));
            if(stk.size() >= part.length() && stk.peek() == part.charAt(part.length()-1)) {
                checkMatch(stk, part);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }

        return result.reverse().toString();
    }

    private void checkMatch(Stack<Character> stk, String part) {
        Stack<Character> s = new Stack<>();

        for(int partIndex = part.length() - 1; partIndex >= 0; partIndex--) {
            if(stk.isEmpty() || stk.peek() != part.charAt(partIndex)) {
                // add back to original stack if match fails
                while(!s.isEmpty())
                    stk.push(s.pop());

                break;
            }
            s.push(stk.pop());
        }
    }
}
