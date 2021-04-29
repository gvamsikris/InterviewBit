package com.gvamsikris.interviewbit.twoPointers;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int area = 0;
        for (int i = 0, j = A.size() - 1; i < j; ) {
            area = Math.max(area, (Math.min(A.get(i), A.get(j)) * (j - i)));
            if (A.get(i) < A.get(j)) {
                i++;
            }
            else {
                j--;
            }
        }
        return area;
    }
}
