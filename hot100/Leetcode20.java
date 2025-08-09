package hot100;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '{' || charAt == '(' || charAt == '[') {
                stack.push(charAt);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '{') {
                    if (charAt != '}') {
                        return false;
                    }
                }
                if (pop == '[') {
                    if (charAt != ']') {
                        return false;
                    }
                }
                if (charAt != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
