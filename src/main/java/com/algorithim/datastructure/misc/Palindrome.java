package com.algorithim.datastructure.misc;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.palindromeEasy("madam"));
        System.out.println(palindrome.palindromeComplex("radar"));
    }

    private boolean palindromeComplex(String string) {
        int i = 0;
        int j = string.length() - 1;
        int k = ( i + j ) / 2;
        for(int index = i;index < k ; index++){
            if(string.charAt(i) == string.charAt(j)){
                i++; j--;
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean palindromeEasy(String string) {
        String reverse = "";
        for(int i=0;i<string.length();i++){
            reverse += string.charAt(string.length() - i - 1);
        }
        return reverse.equals(string);
    }
}
