package com.algorithim.datastructure.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams("railsafety", "fairytales")); // should return true
        System.out.println(anagrams.anagrams("hello", "solleh")); // should return false
        System.out.println(anagrams.isAnagram("railsafety", "fairytales")); // should return true
        System.out.println(anagrams.isAnagram("hellos", "solleh")); // should return false
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

//    49. Group Anagrams
//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//    typically using all the original letters exactly once.
//    Example 1:
//
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // ["eat","tea","tan","ate","nat","bat"]
        for(String str : strs){
            char [] charArray = new char[26];
            // ['e','a','t']
            for(int i = 0; i < str.length(); i++){
                charArray[str.charAt(i) - 'a']++;
            }
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
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
        return stringBuilderOne.toString().equalsIgnoreCase(stringBuilderTwo.toString());
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
        int [] counts = new int[26];
        for(int i=0;i<stringOne.length();i++){
            counts[stringOne.charAt(i) - 'a']++;
            counts[stringTwo.charAt(i) - 'a']--;
        }
        for(int i=0;i<counts.length;i++){
            if(counts[i] != 0) return false;
        }
        return true;
    }
}
