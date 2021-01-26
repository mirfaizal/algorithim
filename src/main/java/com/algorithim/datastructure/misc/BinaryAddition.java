package com.algorithim.datastructure.misc;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BinaryAddition {

    public static void main(String[] args) {
        String s = "a, a, a, a, b,b,b,c, c";
        StringTokenizer words = new StringTokenizer(s," ,");
        while(words.hasMoreTokens()){
            String word = words.nextToken().toLowerCase();
            System.out.println(word);
        }

    }
}
