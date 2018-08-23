package com.alexander;

import java.util.Stack;

public class Test07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Test07 test07 = new Test07();
        for (int i = 0; i < 8; i++) {
            test07.push(i);
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(test07.pop());
        }

    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int a = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return a;
    }
}
