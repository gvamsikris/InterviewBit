package com.gvamsikris.interviewbit.stacksQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(slidingWindowMaximum.slidingMaximum(List.of(1, 3, -1, -3, 5, 3, 6, 7), 3));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result= new ArrayList<>();
        int i = 0;
        for(;i<B;i++) {
            while (!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for(;i<A.size();i++) {
            result.add(A.get(deque.peek()));
            while (!deque.isEmpty() && deque.peek() <= i-B) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result.add(A.get(deque.peek()));
        return result;
    }
}
