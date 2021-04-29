package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class N3RepeatedNumber {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorElements = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
        int length = nums.length;
        int majorityCount = length/3;
        for (int i = 0; i < length; i++) {
            if (first == nums[i]) {
                count1++;
            } else if (second == nums[i]) {
                count2 ++;
            } else if(count1 == 0) {
                first = nums[i];
            } else if (count2 == 0) {
                second = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if(i == first) {
                count1++;
            } else if(i == second) {
                count2++;
            }
        }
        if(count1 > majorityCount) {
            majorElements.add(first);
        }
        if(count2 > majorityCount) {
            majorElements.add(second);
        }
        return majorElements;
    }
}
