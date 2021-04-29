package com.gvamsikris.interviewbit.binarySearch;

/* A Bitonic Sequence is a sequence of numbers which is first strictly increasing
    then after a point strictly decreasing.
*/

import java.util.ArrayList;
import java.util.List;

public class BitonicSearch {

    public int findPeak(List<Integer> list) {
        int size = list.size();
        int low = 0, high = size -1;
        while (low <= high) {
            int mid = low + (high -low) / 2;
            if(mid == 0) {
                if(list.get(0) > list.get(1)) {
                    return 0;
                }
                return 1;
            }
            if(mid == size-1) {
                if (list.get(size - 2) > list.get(size - 1)) {
                    return size-2;
                }
                return size-1;
            }
            int next = mid + 1, prev = mid-1;
            if (list.get(mid) > list.get(prev) && list.get(mid) > list.get(next))
                return mid;
            if (list.get(mid) > list.get(prev)) {
                low = mid +1;
            }
            else if (list.get(mid) < list.get(prev)) {
                high = mid -1;
            }
        }
        return -1;
    }

    public int binarySerchAscending(ArrayList<Integer> list, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == key)
                return mid;
            if (list.get(mid) < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
    public int binarySerchDescending(ArrayList<Integer> list, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == key)
                return mid;
            if (list.get(mid) < key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int peakPos = findPeak(A);
        int found = binarySerchAscending(A, B, 0, peakPos);
        if (found == -1) {
            found = binarySerchDescending(A, B, peakPos +1, A.size()-1);
        }
        return found;
    }
}
