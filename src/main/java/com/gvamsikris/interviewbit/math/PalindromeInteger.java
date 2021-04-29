package com.gvamsikris.interviewbit.math;

public class PalindromeInteger {

    public boolean isPalindrome(int n) {
        int divisor = 1;
        for (; n / divisor >= 10; divisor *= 10) ;
        while (n != 0) {
            int leading = n / divisor;
            int trailing = n % 10;
            if (leading != trailing) {
                return false;
            }

            n = (n % divisor) / 10;
            divisor = divisor / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        for (int i = 0; i < 10000; i++) {
            System.out.print(palindromeInteger.isPalindrome(i) ? i + ", " : "");
        }
    }
}
