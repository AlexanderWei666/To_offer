package com.alexander;

import java.util.ArrayDeque;
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

        QStack qStack = new QStack();
        for (int i = 0; i < 8; i++) {
            qStack.push(i);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(qStack.pop());
        }

    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int a = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return a;
    }
}

//两个队列实现栈，只调用poll和offer
class QStack {
    ArrayDeque<Integer> deque1 = new ArrayDeque<>();
    ArrayDeque<Integer> deque2 = new ArrayDeque<>();
    int last;

    public void push(int node) {
        last = node;
        if (deque2.isEmpty())
            deque1.offer(node);
        if (deque1.isEmpty())
            deque2.offer(node);
    }

    public int pop() {
        int a = 0;
        int b = 0;

        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                a = deque1.poll();
                if(a != last) {
                  b = a;
                  deque2.offer(a);
                }
            }
        } else {
            while (!deque2.isEmpty()) {
                a = deque2.poll();
                if(a != last) {
                    b = a;
                    deque1.offer(a);
                }
            }
        }
        last = b;
        return a;
    }
}
