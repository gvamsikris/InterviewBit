package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;

public class MaxMinSum {

    public int solve(ArrayList<Integer> A) {
        int min = A.get(0);
        int max = A.get(0);
        for(int i = 1; i< A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        return min + max;
    }

}
