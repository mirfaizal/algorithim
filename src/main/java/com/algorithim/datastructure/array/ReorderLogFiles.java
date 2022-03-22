package com.algorithim.datastructure.array;

// You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

// There are two types of logs:

// Letter-logs: All words (except the identifier) consist of lowercase English letters.
// Digit-logs: All words (except the identifier) consist of digits.
// Reorder these logs so that:

// The letter-logs come before all digit-logs.
// The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
// The digit-logs maintain their relative ordering.
// Return the final order of the logs.


// Example 1:

// Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
// Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
// Explanation:
// The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
// The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
// Example 2:

// Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
// Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

import java.util.Arrays;

public class ReorderLogFiles {

    public static int compare(String log1, String log2) {
        // "dig1 8 1 5 1","let1 art can"
        String [] split1 = log1.split(" ", 2);
        String [] split2 = log2.split(" ", 2);

        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

        // "ab1 off key dog","a8 act zoo"
        // If both are not digit
        if(!isDigit1 && !isDigit2){
            int compare = split1[1].compareTo(split2[1]);
            if(compare != 0) {
                return compare;
            }
            return split1[0].compareTo(split2[0]);
        }
        if((!isDigit1 && isDigit2) ){
            return -1;
        }else if((isDigit1 && !isDigit2) ){
            return 1;
        }
        // Both are Digit, so return 0
        return 0;
    }
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, ReorderLogFiles::compare);
        return  logs;
    }
    public static void main(String[] args) {
        String[] result = reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        printResult(result);
        result = reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        printResult(result);
    }

    private static void printResult(String[] result) {
        for(String s : result) System.out.print(s+",");
        System.out.println();
    }
}
