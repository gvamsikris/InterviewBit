package com.gvamsikris.interviewbit.twoPointers;

import java.util.ArrayList;

public class MergeSortedArrays {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int aSize = a.size();
        int bSize = b.size();
        int bIndex = 0;
        for (int i =0; i < a.size(); i++ ) {
            int bVal = bIndex < bSize ? b.get(bIndex) : Integer.MAX_VALUE;
            if(a.get(i) >= bVal) {
                a.add(i, bVal);
                bIndex++;
            }
        }
        for(;bIndex < bSize; bIndex++) {
            a.add(b.get(bIndex));
        }
    }
}
