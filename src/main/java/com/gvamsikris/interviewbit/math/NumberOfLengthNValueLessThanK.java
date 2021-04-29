package com.gvamsikris.interviewbit.math;

import java.util.List;
// https://www.geeksforgeeks.org/count-of-integers-of-length-n-and-value-less-than-k-such-that-they-contain-digits-only-from-the-given-set/

public class NumberOfLengthNValueLessThanK {

    final static int MAX = 10;

    public static void main(String[] args) {
        NumberOfLengthNValueLessThanK number = new NumberOfLengthNValueLessThanK();
        System.out.println(number.solve(List.of(0, 1, 5), 1, 2));
        System.out.println(number.solve(List.of(0, 1, 2, 5), 2, 21));
    }

    public int solve(List<Integer> A, int B, int C) {
        int answer = 0;
        int cLength = String.valueOf(C).length();
        int cArray[] = new int[cLength];
        for (int i = 0; i < cLength; i++) {
            cArray[i] = Integer.valueOf("" + String.valueOf(C).charAt(i));
        }
        //System.out.println(Arrays.toString(cArray));
        if (B > cLength || A.size() == 0) {
            return 0;
        }
        else if (B < cLength) {
            // Contains 0
            if (A.get(0) == 0 && B != 1)
                return (int) ((A.size() - 1) * Math.pow(A.size(), B - 1));
            else
                return (int) Math.pow(A.size(), B);
        }
        else {
            int[] dp = new int[B + 1];
            int[] lower = new int[MAX + 1];
            for (int i = 0; i < A.size(); i++) {
                lower[A.get(i) + 1] = 1;
            }
            for (int i = 1; i <= MAX; i++) {
                lower[i] = lower[i - 1] + lower[i];
            }
            //System.out.println(Arrays.toString(lower));
            boolean flag = true;
            dp[0] = 0;
            for (int i = 1; i <= B; i++) {
                int d2 = lower[cArray[i - 1]];
                dp[i] = dp[i - 1] * A.size();

                // For first index we can't use 0
                if (i == 1 && A.get(0) == 0 && B != 1)
                    d2 = d2 - 1;

                // Whether (i-1) digit of generated number
                // can be equal to (i - 1) digit of C
                if (flag)
                    dp[i] += d2;

                // Is cArray[i - 1] present in A ?
                flag = (flag & (lower[cArray[i - 1] + 1] ==
                        lower[cArray[i - 1]] + 1));
            }
            return dp[B];
        }
    }
}
