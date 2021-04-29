package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;

public class FindMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        // To mark the occurrence of elements
        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0 && A.get(i) <= n)
                present[A.get(i)] = true;
        }
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;
        return n + 1;
    }
}
