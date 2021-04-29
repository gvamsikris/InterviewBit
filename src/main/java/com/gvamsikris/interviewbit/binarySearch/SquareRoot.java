package com.gvamsikris.interviewbit.binarySearch;

public class SquareRoot {

    public int findSqrt(int number) {
        if(number ==0 || number ==1) {
            return number;
        }
        int low = 1, high = number;
        while (low <= high) {
            double mid = low + (high - low) / 2;
            if((mid*mid) == number) {
                return (int) Math.floor(mid);
            } else if ((mid*mid) > number) {
                high = (int) mid-1;
            } else {
                low = (int) mid +1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.findSqrt(308634616));
    }
}
