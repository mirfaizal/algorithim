package com.algorithim.datastructure.array;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(anagram("madam","damma"));
    }

    private static boolean anagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char [] asciiArray = new char[26];
        for(int i=0;i<s1.length();i++){
            asciiArray[s1.charAt(i) - 'a']++;
            asciiArray[s2.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++){
            if(asciiArray[i] != 0) return false;
        }
        return true;
    }
}
