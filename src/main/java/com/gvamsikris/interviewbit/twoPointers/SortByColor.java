package com.gvamsikris.interviewbit.twoPointers;

import java.util.ArrayList;

public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {
        int redCount = 0;
        int whiteCount = 0;
        int size = a.size();
        for (int i : a) {
            if (i == 0) {
                redCount++;
            }
            else if (i == 1) {
                whiteCount++;
            }
        }
        for(int i=0; i< a.size(); i++) {
            if(i < redCount) {
                a.set(i, 0);
            } else if (i < whiteCount) {
                a.set(i, 1);
            } else {
                a.set(i, 2);
            }
        }
    }
}
