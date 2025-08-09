package Stacks;

import java.util.Stack;

/*
Given String have valid parentheses
((a+b) + b) not contains duplicate parentheses : false
((a+b)) contains : true
 */
public class DuplicateParentheses {
    public static void main(String[] args) {
        String s = "((a+b))";
        System.out.println(duplicateParentheses(s));
    }

    private static boolean duplicateParentheses(String s) {
        if (s.isEmpty()) return false;
        Stack<Character> st = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (cur != ')') st.push(cur);
            else {
                int count = 0;
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count == 0) return true;
                st.pop();
            }
        }
        return false;
    }
}

