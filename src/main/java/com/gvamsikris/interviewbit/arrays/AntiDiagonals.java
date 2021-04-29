package com.gvamsikris.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonals {
    public static Integer[][] createAntiDiagonals(int[][] matrix) {
        List<List<Integer>> antiDiagonals = new ArrayList<>();
        int n = matrix.length;
        System.out.println("length: " + n);
        for (int i = 0; i < (2 * n - 1); i++) {
            antiDiagonals.add(new ArrayList<>());
        }
        Integer[][] result = new Integer[2 * matrix.length - 1][];

        for (int i = 0; i < matrix.length; i++) {
            Integer[] line = new Integer[i+1];
            result[i] = line;
            for (int j = 0; j <= i; j++) {
                line[j] = matrix[j][i-j];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            Integer[] line = new Integer[matrix.length - i];
            result[matrix.length + i - 1] = line;
            int k = 1;
            for (int j = i; j < matrix.length; j++) {
                line[j-i] = matrix[j][matrix.length-k];
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] {
                {1,2},
                {3,4},
        };
        System.out.println(Arrays.deepToString(createAntiDiagonals(M)));
    }
}
