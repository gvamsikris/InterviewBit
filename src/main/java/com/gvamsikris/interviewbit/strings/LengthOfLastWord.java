package com.gvamsikris.interviewbit.strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        char[] chars = A.toCharArray();
        int counter = 0;
        int length = 0;
        for(char c: chars) {
            if(c == ' ') {
                if(counter != 0) {
                    length = counter;
                }
                counter = 0;
            } else {
                counter++;
            }
        }
        if(counter != 0) {
            length = counter;
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord length = new LengthOfLastWord();
        System.out.println(length.lengthOfLastWord("d"));
        System.out.println(length.lengthOfLastWord("Hello World  "));
    }
}
