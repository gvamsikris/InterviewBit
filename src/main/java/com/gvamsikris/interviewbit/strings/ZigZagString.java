package com.gvamsikris.interviewbit.strings;

public class ZigZagString {
    public static void main(String[] args) {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("PAYPALISHIRING", 3));
    }

    public String convert(String A, int B) {
        if (B <= 1) {
            return A;
        }
        String[] strArray = new String[B];
        for (int i = 0; i < B; i++) {
            strArray[i] = "";
        }
        int length = A.length();
        boolean down = true;
        int currentRow = 1;
        for (int i = 0; i < A.length(); i++) {
            strArray[currentRow - 1] += A.charAt(i);
            if (down) {
                currentRow++;
            }
            else {
                currentRow--;
            }
            if (currentRow == B) {
                down = false;
            }
            if (currentRow == 1) {
                down = true;
            }
        }
        String result = "";
        for (String str : strArray) {
            result += str;
        }
        return result;
    }
}
