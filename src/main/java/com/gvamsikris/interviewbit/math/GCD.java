package com.gvamsikris.interviewbit.math;

public class GCD {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(2, 3));
        System.out.println(gcd.gcd(6, 9));
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
