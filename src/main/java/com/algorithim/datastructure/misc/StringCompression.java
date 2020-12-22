package com.algorithim.datastructure.misc;

import java.util.Map;
import java.util.HashMap;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compression("aaBccccDDkkk"));
        System.out.println(compression("abcd"));
    }

    static String compression(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString().length() < str.length() ? sb.toString() : str;
    }
}
