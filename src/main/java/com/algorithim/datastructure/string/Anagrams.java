package com.algorithim.datastructure.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams("railsafety", "fairytales")); // should return true
        System.out.println(anagrams.anagrams("hello", "solleh")); // should return false

        System.out.println(anagrams.isAnagram("railsafety", "fairytales")); // should return true
        System.out.println(anagrams.isAnagram("hello", "solleh")); // should return false
    }

    private boolean anagrams(String stringOne, String stringTwo) {
        Map<Character, Integer> stringOneMap = new HashMap<>(), stringTwoMap = new HashMap<>();
        createMapFromString(stringOne.toLowerCase(), stringOneMap);
        createMapFromString(stringTwo.toLowerCase(), stringTwoMap);
        if(stringOneMap.keySet().size() != stringTwoMap.keySet().size()){
            return false;
        }
        for(Map.Entry<Character,Integer> entryOne : stringOneMap.entrySet()){
            for(Map.Entry<Character,Integer> entryTwo : stringTwoMap.entrySet()){
                return ((entryOne.getKey() == entryTwo.getKey()) && (entryOne.getValue() == entryTwo.getValue()));
            }
        }
        return true;
    }

    private boolean anagramUsingSort(String stringOne, String stringTwo){
        char[] stringOneCharArray = stringOne.toCharArray();
        char[] stringTwoCharArray = stringTwo.toCharArray();
        Arrays.sort(stringOneCharArray);
        Arrays.sort(stringTwoCharArray);
        StringBuilder stringBuilderOne = new StringBuilder();
        StringBuilder stringBuilderTwo = new StringBuilder();
        for(char c: stringOneCharArray){
            stringBuilderOne.append(c);
        }
        for(char c: stringTwoCharArray){
            stringBuilderTwo.append(c);
        }
        if(stringBuilderOne.toString().equalsIgnoreCase(stringBuilderTwo.toString())){
            return true;
        }
        return false;
    }

    private void createMapFromString(String string, Map<Character, Integer> stringMap) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            Integer value = stringMap.get(c);
            if(value != null){
                stringMap.put(c,value + 1);
            }else{
                stringMap.put(c,1);
            }
        }
    }

    // O(n)
    public boolean isAnagram(String stringOne, String stringTwo ){
        if(stringOne.length() != stringTwo.length()) return false;
        int [] counts = new int[128];
        for(int i=0;i<stringOne.length();i++){
            counts[stringOne.charAt(i) - 'a']++;
            counts[stringTwo.charAt(i) - 'a']--;
        }
        return true;
    }
}
