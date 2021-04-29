package com.gvamsikris.interviewbit.arrays;

import java.util.List;

public class MaxDistance {

    public int maxDistance(List<Integer> A) {
        int maxDiff = -1;
        int i = 0, j = 0;
        int n = A.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];
        LMin[0] = A.get(0);
        for (int k = 0; k < n; k++) {
            LMin[k] = Math.min(A.get(k), LMin[k-1]);
        }
        RMax[n-1] = A.get(n-1);
        for (int k = n-2; k >= 0; k--) {
            RMax[k] = Math.max(A.get(k), RMax[k+1]);
        }
        while (i < n && j < n) {
            if(LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }
        }
        return maxDiff;
    }
}
