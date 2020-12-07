package com.algorithim.misc;

public class StringReverse {

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();
        System.out.println(sr.reverse("12345"));
    }

    private String reverse(String string) {
        StringBuilder reverse = new StringBuilder();
        for(int i = 0 ;i< string.length(); i++){
            reverse.append(string.charAt(string.length()-i-1));
        }
        return reverse.toString();
    }
}
