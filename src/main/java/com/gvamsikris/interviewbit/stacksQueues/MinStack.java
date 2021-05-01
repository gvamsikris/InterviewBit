package com.gvamsikris.interviewbit.stacksQueues;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int minValue = Math.min(x, minStack.peek());
            minStack.push(minValue);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
