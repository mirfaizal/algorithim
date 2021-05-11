package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
//    Given a string that might contain duplicate characters, find all the possible distinct subsets of that string.
//    Example One:
//    Input: “aab”
//    Output: [“”, “a”, “aa”, “aab”, “ab”, “b”]
//    Example Two:
//    Input: “dc”
//    Output: [“”, “c”, “cd”, “d”]
    public static void main(String[] args) {
        List<String> distinctSubset = get_distinct_subsets("122");
        for(String s : distinctSubset) System.out.print(s+" ");
    }
    static List<String> distinctSubset = new ArrayList<>();
    public static List<String> get_distinct_subsets(String str) {
        char [] charArray = str.toCharArray();
        Arrays.sort(charArray);
        get_distinct_subsets(charArray, 0 , new StringBuilder());
        return distinctSubset;
    }
    private static void get_distinct_subsets(char [] problemDef, int index, StringBuilder slate) {
        // Base Case
        if(index == problemDef.length) {
            distinctSubset.add(slate.toString());
            return;
        }
        // Recursive Case
        int count = 0;
        for(int i = index;i<problemDef.length;i++){
            if(problemDef[i] != problemDef[index]) break;
            count++;
        }
        // Exclude
        get_distinct_subsets(problemDef,index + count , slate);
        // Multi-Include
        for(int i=0;i<count;i++){
            slate.append(problemDef[index]);
            get_distinct_subsets(problemDef,index + count , slate);
        }
        for(int i=0;i<count;i++){
            slate.setLength(slate.length() - 1);
        }

    }
}
