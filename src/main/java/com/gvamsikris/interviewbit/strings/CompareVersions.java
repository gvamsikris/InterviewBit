package com.gvamsikris.interviewbit.strings;

import java.math.BigInteger;

public class CompareVersions {
    public static void main(String[] args) {
        CompareVersions compareVersions = new CompareVersions();
        System.out.println(compareVersions.compareVersion("1.0", "1"));
    }
    public int compareVersion(String v1, String v2) {
        String[] v1Split = v1.split("[.]");
        String[] v2Split = v2.split("[.]");
        int i = 0, j = 0;
        for(; i < v1Split.length && j < v2Split.length; i++, j++) {
            BigInteger bigInteger1 = new BigInteger(v1Split[i]);
            BigInteger bigInteger2 = new BigInteger(v2Split[j]);
            int compredBigInt = bigInteger1.compareTo(bigInteger2);
            if(compredBigInt == 0) {
                continue;
            } else {
                return compredBigInt;
            }
        }
        if(i != v1Split.length) {
            if(!v1Split[v1Split.length-1].equals("0")) {
                return 1;
            }
        }
        if(j != v2Split.length) {
            if(!v2Split[v2Split.length-1].equals("0")) {
                return -1;
            }
        }
        return 0;
    }
}
