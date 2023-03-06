package com.algorithim.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 3[a2[b2[c]]] ---> abccbccabccbccabccbcc
 * 3[a]2[bc] ---> bcaaabcaaa
 * 3[ad2[c]] ---> adccadccadcc
 * 3[gh] ---> ghghgh
 *
 */

public class DecryptString {
    public static String decrypt(String str){
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int i = 0;
        while(i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                numStack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
                i++;
            }
            if(i < str.length() && str.charAt(i) == '[') i++;
            StringBuilder inner = new StringBuilder();
            while(i < str.length() && Character.isLetter(str.charAt(i))){
                inner.append(str.charAt(i));
                i++;
            }
            if(inner.length() > 0){
                strStack.push(inner.toString());
            }
            // numStack = [3,2]
            // strStack = [ad,c]
            if(i < str.length() && str.charAt(i) == ']' && !strStack.isEmpty() && !numStack.isEmpty()) {
                String strFromStack = strStack.pop();
                int countFromStack = numStack.pop();
                StringBuilder tempString = new StringBuilder(sb);
                if(sb.length() != 0) {
                    // Add str to front
                    tempString.insert(0, strFromStack);
                }
                int index = 0;
                while(index < countFromStack) {
                    if(tempString.length() == 0) {
                        sb.append(strFromStack);
                    } else {
                        if(index == 0) {
                            sb = new StringBuilder();
                        }
                        sb.append(tempString);
                    }
                    index++;
                }
                // sb = [cc]
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        System.out.println("3[a2[b2[c]]] ---> " + decrypt("3[a2[b2[c]]]"));
        System.out.println("3[a]2[bc] ---> " + decrypt("3[a]2[bc]"));
        System.out.println("3[ad2[c]] ---> " + decrypt("3[ad2[c]]"));
        System.out.println("3[gh] ---> " + decrypt("3[gh]"));
    }

}
