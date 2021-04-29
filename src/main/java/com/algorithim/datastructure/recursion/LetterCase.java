package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCase {
    public static void main(String[] args) {
        List<String>  list = letter_case_permutations("a1b2");
        for(String s : list) System.out.print(s+" ");
    }
    static List<String> result = new ArrayList<>();
    public static List<String> letter_case_permutations(String str) {
        letter_case_permutations(str, 0, new StringBuilder());
        return result;
    }
    private static void letter_case_permutations(String pd, int index, StringBuilder slate) {
        // Base case
        if(index == pd.length()) {
            result.add(slate.toString());
            return;
        }
        // Recursive case
        char c = pd.charAt(index);
        if(Character.isDigit(c)){
            slate.append(c);
        }else {
            slate.append(Character.toUpperCase(c));
            letter_case_permutations(pd,index + 1, slate);
            slate.setLength(slate.length() - 1);
            slate.append(Character.toLowerCase(c));
        }
        letter_case_permutations(pd,index + 1, slate);
        slate.setLength(slate.length() - 1);
    }
}
