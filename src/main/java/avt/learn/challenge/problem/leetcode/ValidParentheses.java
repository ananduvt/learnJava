package avt.learn.challenge.problem.leetcode;

import java.util.*;

public class ValidParentheses {

//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
//
//    Example 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "()[]{}"
//    Output: true
//    Example 3:
//
//    Input: s = "(]"
//    Output: false
//
//    Constraints:
//
//    1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.

    public boolean isValid(String s) {
        Map<String, String> paraMap = Map.of(")", "(", "]", "[", "}", "{");
        Deque<String> stack = new LinkedList<>();
        for (String c : s.split("")) {
            if (paraMap.get(c) != null && !stack.isEmpty() && paraMap.get(c).equals(stack.peek())) {
                stack.removeLast();
            } else {
                stack.addFirst(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new ValidParentheses().isValid("()"));
        System.out.println(new ValidParentheses().isValid("()[]{}"));
        System.out.println(new ValidParentheses().isValid("(]"));
        System.out.println(new ValidParentheses().isValid("([)]")); // false
        System.out.println(new ValidParentheses().isValid("]")); // false
    }
}
