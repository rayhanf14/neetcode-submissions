class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> open = List.of('{', '(', '[');
        List<Character> close = List.of('}', ')', ']');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (open.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') || (ch == '}' && top != '{')
                    || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
