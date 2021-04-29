package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < B; i++) {
            stack.push(i +1);
            if(i == B -1 || A.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindPermutation findPermutation = new FindPermutation();
        System.out.println(findPermutation.findPerm("ID", 3));
    }
}
