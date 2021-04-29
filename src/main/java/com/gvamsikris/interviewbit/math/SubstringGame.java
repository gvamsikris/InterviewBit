package com.gvamsikris.interviewbit.math;

public class SubstringGame {

    public String solve(String A) {
        int play = 1;
        return game(A, play);
    }
    public String game(String A, int play) {
        if(!isPalindrome(A)) {
            return "Alice";
        } else if(allAllCharcterSame(A)) {
            return "Bob";
        } else {
            return "Alice";
        }
        /*int end = A.length() - 1;
        if(!isPalindrome(A.substring(0, end))) {
            A = A.substring(end);
        } else if (!isPalindrome(A.substring(1, end + 1))) {
            A = A.substring(0, 1);
        }
        if(isPalindrome(A) || A.length() <= 2) {
            return play%2 == 0 ? "Alice" : "Bob";
        }
        play++;
        return game(A, play);*/
    }

    public static boolean allAllCharcterSame(String A) {
        char A0 = A.charAt(0);
        for (int i =1; i < A.length(); i++) {
            if(A0 != A.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String A) {
        int end = A.length() - 1;
        int start = 0;
        for (; start < end; start++, end--) {
            if(A.charAt(start) != A.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringGame substringGame = new SubstringGame();
        System.out.println(substringGame.solve("ze"));
    }

}
