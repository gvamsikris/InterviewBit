package com.gvamsikris.interviewbit.twoPointers;

import java.util.ArrayList;

public class DiffK {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int size = A.size();
        for (int i = 0, j = 1; i < size && j < size; ) {
            int diff = A.get(j) - A.get(i);
            if (i != j && diff == B) {
                return 1;
            }
            else if (diff < B) {
                j++;
            }
            else {
                i++;
            }
        }
        return 0;
    }
}
