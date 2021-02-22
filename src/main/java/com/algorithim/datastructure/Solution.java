package com.algorithim.datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        isIsomorphic("foo","app");
        char [] s = "".toCharArray();
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int difference = s.charAt(i) - t.charAt(i);
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != difference) {
                    System.out.println("false");
                    return false;
                }
            } else {
                map.put(s.charAt(i), difference);
            }
        }
        return getFrequency(s).equals(getFrequency(t));
    }

    private static String getFrequency(String s){
        StringBuilder sbS = new StringBuilder();
        Map<Character, Integer> mapS = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1);
            }
            System.out.println(mapS.get(s.charAt(i)));
        }
        for(Map.Entry<Character, Integer> entry : mapS.entrySet()){
            sbS.append(entry.getValue());
        }

        return sbS.toString();
    }

}
