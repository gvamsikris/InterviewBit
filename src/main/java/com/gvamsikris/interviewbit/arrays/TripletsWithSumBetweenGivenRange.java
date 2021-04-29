package com.gvamsikris.interviewbit.arrays;

import java.util.List;

public class TripletsWithSumBetweenGivenRange {

    public static int minRange = 1;
    public static int maxRange = 2;

    public int findTriplet(List<String> values) {
        double sum = 0;
        int minIndex = 0; int maxIndex = 0;
        double[] triplet = new double[3];
        for(int i = 0; i< 3; i++) {
            triplet[i] = Double.parseDouble(values.get(i));
            sum += triplet[i];
            if(triplet[i] < triplet[minIndex]) {
                minIndex = i;
            }
            if(triplet[i] > triplet[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i=3; i < values.size(); i++) {
            double value = Double.parseDouble(values.get(i));
            if(minRange < sum && sum < maxRange) {
                return 1;
            }
            if(sum >= maxRange && value < triplet[maxIndex]) {
                sum -= triplet[maxIndex];
                triplet[maxIndex] = value;
                sum += value;
            }
            if(sum <= minRange && value > triplet[minIndex]) {
                sum -= triplet[minIndex];
                triplet[minIndex] = value;
                sum += value;
            }
            for (int j=0; j<3; j++) {
                if(triplet[j] < triplet[minIndex]) {
                    minIndex = j;
                }
                if(triplet[j] > triplet[maxIndex]) {
                    maxIndex = j;
                }
            }
        }
        return (minRange < sum && sum < maxRange) ? 1 : 0;
    }
}
