package com.algorithim.misc;

public class CapitalizedWordInString {
    public static void main(String[] args) {
        CapitalizedWordInString capitalizedWordInString = new CapitalizedWordInString();
        System.out.println(capitalizedWordInString.capitalizedWord("hello there how are you!"));
    }

    private String capitalizedWord(String string) {
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<string.length();i++){
            if(i == 0 || ((i - 1) > 0 && Character.isSpaceChar(string.charAt(i - 1)))) {
                newString.append(Character.toUpperCase(string.charAt(i)));
            }else{
                newString.append(string.charAt(i));
            }
        }
        return newString.toString();
    }
}
