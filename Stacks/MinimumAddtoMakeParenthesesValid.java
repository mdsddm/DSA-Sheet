package Stacks;

import java.util.Stack;

/*  921. Minimum Add to Make Parentheses Valid
A parentheses string is valid if and only if:
It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3
 
Constraints:
1 <= s.length <= 1000
s[i] is either '(' or ')'.   */
public class MinimumAddtoMakeParenthesesValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid2("())"));
    }
    // using stack
    private static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
    
    private static int minAddToMakeValid2(String s) {
        int n = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                n++;
            } else {
                n--;
            }
        }
        return Math.abs(n);
    }

}