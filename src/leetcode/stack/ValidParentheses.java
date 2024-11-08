package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.isValid("()");
        s.isValid("()[]{}");
        s.isValid("(]");
        s.isValid("([])");
    }

    public static class Solution {
        /*
        () {} [] 괄호 잘 여닫혔는지 체크
         */
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> pairMap = new HashMap<>();

            pairMap.put(')', '(');
            pairMap.put('}', '{');
            pairMap.put(']', '[');

            for(char c : s.toCharArray()) {
                stack.push(c);

                // ) 하나만 있는거
                if (c == ')' || c == '}' || c == ']') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        char openChar = stack.pop();
                        if (openChar != pairMap.get(c)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }

            if (!stack.isEmpty()) {
                return false;
            }

            return true;
        }
    }
}
