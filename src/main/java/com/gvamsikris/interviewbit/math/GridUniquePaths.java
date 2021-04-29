package com.gvamsikris.interviewbit.math;

public class GridUniquePaths {

    public int uniquePaths(int A, int B) {
        int dp[][] = new int[A][B];
        for (int i = 0; i < A; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < B; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < A; i++) {
            for (int j = 1; j < B; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[A - 1][B - 1];
    }

    public static void main(String[] args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        System.out.println(gridUniquePaths.uniquePaths(2, 2));
        System.out.println(gridUniquePaths.uniquePaths(3, 3));
        System.out.println(gridUniquePaths.uniquePaths(3, 7));
    }

}
