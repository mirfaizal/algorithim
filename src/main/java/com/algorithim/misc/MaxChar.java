package com.algorithim.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MaxChar {

    public static void main(String[] args) {
        MaxChar maxChar = new MaxChar();
        System.out.println(maxChar.maxChar("AABBCCDDDDDDDDDX"));
    }

    // Most used char
    // maxChar("ABBBCCCCCCCCD") returns C
    private char maxChar(String string) {
        char [] charArray = string.toCharArray();
        Map<Character, Integer>  map = new HashMap<>();
        for(char c : charArray){
            Integer value = map.get(c);
            if(value != null){
                map.put(c,value + 1);
            } else {
                map.put(c,1);
            }
        }
        char maxKey = 0;
        int maxValue = 0;
        for( Map.Entry<Character, Integer> entry : map.entrySet()){
            if(maxValue < entry.getValue()){
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
