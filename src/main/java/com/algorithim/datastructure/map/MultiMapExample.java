package com.algorithim.datastructure.map;

public class MultiMapExample {
    public static String countAndSay(int n) {
        StringBuilder current = new StringBuilder();
        StringBuilder previous = new StringBuilder("1");
        if (n == 1) return previous.toString();
        for (int i = 1; i < n; i++) {
            char currChar = previous.charAt(0);
            int count = 1;
            for (int j = 1; j < previous.length(); j++) {
                if (currChar != previous.charAt(j)) {
                    current.append(count).append(currChar);
                    currChar = previous.charAt(j);
                    count = 1;
                } else {
                    count++;
                }

            }
            current.append(count).append(currChar);
            previous = current;
            current = new StringBuilder();
        }
        return previous.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }
}
