package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    public static void main(String[] args) {
        List<String> words = phoneNumber("5683");
        for (String word : words) System.out.print(word+" ");
    }
    static List<String> result = new ArrayList<>();
    static Map<Character,String> phoneMap = new HashMap<>();
    static
    {
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
    }
    public static List<String> phoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.replace("1","");
        phoneNumber = phoneNumber.replace("0","");
        phoneNumber(phoneNumber,0,new StringBuilder());
        return result;
    }
    private static void phoneNumber(String problemDef, int index, StringBuilder slate) {
        // Base Case
        if(index == problemDef.length()){
            result.add(slate.toString());
            return;
        }
        // Recursive Case
        String word = phoneMap.get(problemDef.charAt(index));
        for (char c : word.toCharArray()) {
            slate.append(c);
            phoneNumber(problemDef,index + 1, slate);
            slate.setLength(slate.length() - 1);
        }
    }
}
