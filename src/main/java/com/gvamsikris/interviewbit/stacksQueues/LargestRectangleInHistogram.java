package com.gvamsikris.interviewbit.stacksQueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> posStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        int largestArea = 0, tempArea = 0;
        if(A != null && !A.isEmpty()) {
            posStack.push(0);
            heightStack.push(A.get(0));
        } else {
            return largestArea;
        }
        int pos;
        for (pos = 1; pos < A.size(); pos++) {
            int height = A.get(pos);
            int tempPos = posStack.peek();
            if(heightStack.peek() < height)  {
                posStack.push(pos);
                heightStack.push(A.get(pos));
            } else {
                while (!heightStack.isEmpty() && height < heightStack.peek()) {
                    tempPos = posStack.peek();
                    largestArea = getLargestArea(posStack, heightStack, largestArea, pos);
                }
                heightStack.push(height);
                posStack.push(tempPos);
            }
        }
        while (!heightStack.isEmpty()) {
            largestArea = getLargestArea(posStack, heightStack, largestArea, pos);
        }
        return largestArea;
    }

    private int getLargestArea(Stack<Integer> posStack, Stack<Integer> heightStack, int largestArea, int pos) {
        int tempArea;
        int tempH = heightStack.pop();
        int tempPos = posStack.pop();
        tempArea = tempH * (pos - tempPos);
        largestArea = Math.max(largestArea, tempArea);
        return largestArea;
    }
}
