package com.gvamsikris.interviewbit.strings;

public class MinCharRequiredToMakePalindrome {
    public boolean isPalindrome(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public int minCharsReq(String str) {
        int count = 0;
        while (str.length() > 0) {
            if (isPalindrome(str)) {
                return count;
            }
            else {
                str = str.substring(0, str.length() - 1);
                count++;
            }
        }
        return count;
    }
}
