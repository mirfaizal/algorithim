package com.algorithim.datastructure.dynamicprogramming;

public class EditDistance {

    public static void main(String[] args) {
        dynamicEditDistance( "abcdef","azced");
    }

    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    public static int dynamicEditDistance(String word1, String word2){
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i < dp[0].length; i++) dp[0][i] = i;
        for(int i=0; i < dp.length; i++) dp[i][0] = i;
        for(int i=1;i <=word1.length(); i++){
            for(int j=1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }

    public static int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length() + 1][word2.length()+1];
        int rows = dp.length;
        int cols = dp[0].length;
        for(int i=0; i < cols; i++) dp[0][i] = i;
        for(int i=0; i < rows; i++) dp[i][0] = i;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]), dp[i-1][j]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
