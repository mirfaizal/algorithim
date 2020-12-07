package com.algorithim.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams("rail safety", "fairy tales")); // should return true
        System.out.println(anagrams.anagrams("RAIL! SAFETY!", "fairy tales")); // should return true
        System.out.println(anagrams.anagrams("Hello", "solleH")); // should return false

        System.out.println(anagrams.anagramUsingSort("rail safety", "fairy tales")); // should return true
        System.out.println(anagrams.anagramUsingSort("RAIL! SAFETY!", "fairy tales")); // should return true
        System.out.println(anagrams.anagramUsingSort("Hello", "solleH")); // should return false
    }

    private boolean anagrams(String stringOne, String stringTwo) {
        stringOne = stringOne.replace("!","");
        stringTwo = stringTwo.replace("!","");
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
        stringOne = stringOne.replace("!","");
        stringTwo = stringTwo.replace("!","");
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
}
