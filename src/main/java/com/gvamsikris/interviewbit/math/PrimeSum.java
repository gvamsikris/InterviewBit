package com.gvamsikris.interviewbit.math;

import java.util.ArrayList;

public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] primes = findPrimes(A);
        for (int i = 2; i <= A; i++) {
            if(primes[i] && primes[A-i]) {
                result.add(i);
                result.add(A-i);
                return result;
            }
        }
        return result;
    }

    public boolean[] findPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i*i <= n; i++) {
            if(primes[i]) {
                for(int j = i*i; j<=n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
