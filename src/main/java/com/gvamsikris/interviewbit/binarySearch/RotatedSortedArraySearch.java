package com.gvamsikris.interviewbit.binarySearch;

import java.util.List;

public class RotatedSortedArraySearch {

    private int findPivot(List<Integer> list) {
        for(int i=1; i < list.size(); i++) {
            if(list.get(i) < list.get(i-1)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(List<Integer> list, int key, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == list.get(mid))
            return mid;
        if (key > list.get(mid))
            return binarySearch(list, key, mid +1, high);
        return binarySearch(list, key, low, mid-1);
    }

    public int search(final List<Integer> A, int B) {
        int pivot = findPivot(A);
        if(pivot == -1) {
            binarySearch(A, B, 0, A.size());
        }
        if(A.get(pivot) == B) {
            return pivot;
        }
        if(A.get(0) <= B) {
            return binarySearch(A, B, 0, pivot-1);
        }
        return binarySearch(A, B, pivot+1, A.size());
    }
}
