package com.gvamsikris.interviewbit.binarySearch;

public class ImplementPowerFunction {

    // find x^n % d
    public int pow(int x, int n, int d) {
        if (x == 0)
            return 0;
        long res = 1;
        while (n > 0) {
            if(n%2 == 1) {
                res = (int) ((res * (long)x) % d);
            }
            x = (int) ((long) x * (long) x % d);
            n /= 2;
        }
        res = (res + d) % d;
        return (int) res;
    }
}
