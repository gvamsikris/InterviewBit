package com.gvamsikris.interviewbit.strings;

public class LongestPalindromeSubString {
    public static void main(String[] args) {
        LongestPalindromeSubString longestPalindromeSubString = new LongestPalindromeSubString();
        System.out.println(longestPalindromeSubString.longestPalindrome("ac"));
    }

    public String longestPalindrome(String str) {
        if (str == null || str.length() <= 1)
            return str;

        int len = str.length();
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l = 0; l < str.length(); l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (str.charAt(i) == str.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = str.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }
}
