package com.gvamsikris.interviewbit.strings;

import java.math.BigInteger;

public class PowerOf2 {

    public static void main(String[] args) {
        PowerOf2 power = new PowerOf2();
        System.out.println(power.power("16"));
    }

    public int power(String A) {
        BigInteger originalVal = new BigInteger(A);
        BigInteger val = new BigInteger("2");
        BigInteger _2 = new BigInteger("2");
        int i=1;
        int compareTo = val.compareTo(originalVal);
        while(compareTo < 0) {
            i++;
            val = val.multiply(_2);
            compareTo = val.compareTo(originalVal);
        }
        return compareTo == 0 ? 1 : 0;
    }
}
