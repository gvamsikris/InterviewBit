package com.gvamsikris.interviewbit.strings;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        countAndSay.countAndSay(5);
    }

    public String countAndSay(int number) {
        String result = "1";
        for (int i = 2; i <= number; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = result.toCharArray();
            int prevInt = Integer.parseInt(String.valueOf(chars[0]));
            int count = 1;

            for (int j = 1; j < chars.length; j++) {
                int value = Integer.parseInt(String.valueOf(chars[j]));
                if (value == prevInt) {
                    count++;
                }
                else {
                    sb.append(count).append(prevInt);
                    prevInt = value;
                    count = 1;
                }
            }

            sb.append(count).append(prevInt);

            result = sb.toString();
        }
        return result;
    }
}
