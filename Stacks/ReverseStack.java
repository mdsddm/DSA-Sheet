package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
        printStack(stack);
    }

    // for reverse
    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottomOfStack(stack, top);
    }

    // for print stack
    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }

    // adding item at the bottom
    private static void pushAtBottomOfStack(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottomOfStack(stack, data);
        stack.push(top);

    }
}
