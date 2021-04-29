package com.gvamsikris.interviewbit.math;

import java.util.Arrays;

public class NextSimilarNumber {
    static void swap(char chars[], int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public String nextSimilarNumber(String A) {
        char[] chars = A.toCharArray();
        int length = A.length();
        int i;
        for (i = length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return "-1";
        }
        else {
            int minValue = chars[i - 1];
            int nextMinIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (chars[j] > minValue && chars[j] < chars[nextMinIndex]) {
                    nextMinIndex = j;
                }
            }
            swap(chars, i - 1, nextMinIndex);
            Arrays.sort(chars, i, length);
            return new String(chars);
        }
    }
}
