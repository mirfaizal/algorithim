package com.algorithim.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String word = "appleetcodebananaapple";
        System.out.println(recursion(word,new ArrayList<>(Arrays.asList("leet","code","apple","app","a","banana"))));
        System.out.println(wordBreak(word,new ArrayList<>(Arrays.asList("leet","code","apple","app","a","banana"))));
    }
    static Set<String> set = new HashSet<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
       boolean [] dp = new boolean[s.length()+1];
       // Base Case
       dp[0] = true;
       for(int len=1;len<=s.length();len++){
           for(int i=0;i<len;i++){
               if(dp[i] && wordDict.contains(s.substring(i,len))){
                   dp[len] = true; break;
               }
           }
       }
        return dp[s.length()];
    }
    public static boolean recursion(String s, List<String> wordDict) {
        for(String str : wordDict) set.add(str);
        return dfs(s);
    }
    private static boolean dfs(String word) {
        // Base Case
        if(word.length() == 0) return true;
        for(int i=1;i<=word.length();i++){
            if (set.contains(word.substring(0,i)) && dfs(word.substring(i)))
                return true;
        }
        return false;
    }

}
