package com.gvamsikris.interviewbit.stacksQueues;

import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< A.size();i++) {
            while ((!stack.isEmpty()) && A.get(stack.peek()) < A.get(i)) {
                int popHeight = A.get(stack.peek());
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int minHeight = Math.min(A.get(stack.peek()), A.get(i)) - popHeight;
                result += distance * minHeight;
            }
            stack.push(i);
        }
        return result;
    }
}
