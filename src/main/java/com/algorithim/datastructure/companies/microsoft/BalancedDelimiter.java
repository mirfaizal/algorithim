package com.algorithim.datastructure.companies.microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedDelimiter {
    public static void main(String[] args) {
        System.out.println(isBalancedDelimiter("([{}]))"));
    }

    private static boolean isBalancedDelimiter(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if (c == ')'  && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == '}'  && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else if (c == ']'  && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
