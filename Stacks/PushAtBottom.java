package Stacks;

import java.util.Stack;

public class PushAtBottom {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Before peak : " + stack.peek());
        pushAtBottomOfStack(stack, 4);
        System.out.println("after peak : " + stack.peek());
    }

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
