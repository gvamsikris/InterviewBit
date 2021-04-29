package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PerfectPeak {
    public static void main(String[] args) {
        PerfectPeak perfectPeak = new PerfectPeak();
        /*Integer[] A = new Integer[] { 9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712, 17036, 31323, 8724, 28254, 28704, 26300,
                25548, 15142, 12860, 19913, 32663, 32758 };*/
        Integer[] A = new Integer[] { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
        int result = perfectPeak.perfectPeak(Arrays.asList(A));
        System.out.println("result " + result);
    }

    public int perfectPeak(List<Integer> A) {
        ArrayList<Integer> maxFromLeft = new ArrayList<Integer>(A.size());
        ArrayList<Integer> minFromRight = new ArrayList<Integer>(A.size());
        maxFromLeft.add(A.get(0));
        minFromRight.add(A.get(A.size() - 1));
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > maxFromLeft.get(i - 1)) {
                maxFromLeft.add(i, A.get(i));
            }
            else {
                maxFromLeft.add(i, maxFromLeft.get(i - 1));
            }
        }
        for (int j = A.size() - 2; j >= 0; j--) {
            if (A.get(j) < minFromRight.get(0)) {
                minFromRight.add(0, A.get(j));
            }
            else {
                minFromRight.add(0, minFromRight.get(0));
            }
        }
        //System.out.println(maxFromLeft);
        // System.out.println(minFromRight);
        for (int k = 1; k < A.size() - 1; k++) {
            if (minFromRight.get(k) == maxFromLeft.get(k)) {
                return 1;
            }
        }
        return 0;
    }
}
