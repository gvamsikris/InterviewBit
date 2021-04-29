package com.gvamsikris.interviewbit.math;

public class SieveOfEratosthenes {

    private static void printPrimes(boolean[] primes) {
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        printPrimes(sieveOfEratosthenes.findPrimes(1000));
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
