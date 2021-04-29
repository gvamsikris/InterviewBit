package com.gvamsikris.interviewbit.strings;

public class StrStr {
    public int strStr(final String A, final String B) {
        if(null == A || null == B) {
            return -1;
        }
        if(A.equals(B)) {
            return 0;
        }
        int aLen = A.length();
        int bLen = B.length();
        for (int i = 0; i < aLen - bLen; i++) {
            for (int j = 0; j < bLen; j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    break;
                }
                if (j == (bLen-1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        strStr.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa");
    }
}
