package com.gvamsikris.interviewbit.math;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        ExcelColumnNumber columnNumber = new ExcelColumnNumber();
        for (int i = 1; i <= 16384; i++) {
            System.out.println(columnNumber.excelColumnNumber(i) + "-" + columnNumber.titleToNumber(columnNumber.excelColumnNumber(i)));
        }
    }

    public int titleToNumber(String A) {
        int length = A.length();
        int power = 0;
        int result = 0;
        for(int i = length-1; i >= 0; i--, power++ ) {
            result += Math.pow(26, power) * ((int)(A.charAt(i) - 'A') + 1);
        }
        return result;
    }

    public String excelColumnNumber(int column) {
        int asciiA = 65;
        StringBuilder stringBuilder = new StringBuilder();
        while (column > 0) {
            int reminder = column % 26;
            if (reminder == 0) {
                stringBuilder.append('Z');
                column = (column / 26) - 1;
            }
            else {
                stringBuilder.append((char) ((reminder - 1) + 'A'));
                column = column/26;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
