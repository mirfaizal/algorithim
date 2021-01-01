package com.algorithim.datastructure.string;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacters {
    public static void main(String[] args) {
        UniqueCharacters uniqueCharacters = new UniqueCharacters();
        System.out.println(uniqueCharacters.hasUniqueChar("ABCDEFG")); // Returns True
        System.out.println(uniqueCharacters.hasUniqueChar("AABCDEFG")); // Returns False
    }

    private boolean hasUniqueChar(String string) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ;i < string.length(); i++){
            Integer value = map.get(string.charAt(i));
            if(value !=null){
                return false;
            } else {
                map.put(string.charAt(i),1);
            }
        }
        return true;
    }
}
