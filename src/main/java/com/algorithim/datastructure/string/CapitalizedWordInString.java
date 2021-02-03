package com.algorithim.datastructure.string;

import java.util.StringTokenizer;

public class CapitalizedWordInString {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer();
        st.countTokens()
        System.out.println("hell0".compareTo("hell0"));
        CapitalizedWordInString capitalizedWordInString = new CapitalizedWordInString();
        System.out.println(capitalizedWordInString.capitalizedWord("hello there how are you!"));
    }

    private String capitalizedWord(String string) {
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<string.length();i++){
            if(i == 0 || ((i - 1) > 0 && Character.isSpaceChar(string.charAt(i - 1)))) {
                newString.append(Character.toUpperCase(string.charAt(i)));
            } else {
                String s = String.valueOf(string.charAt(i));
                newString.append(string.charAt(i));
            }
        }
        return newString.toString();
    }
}
