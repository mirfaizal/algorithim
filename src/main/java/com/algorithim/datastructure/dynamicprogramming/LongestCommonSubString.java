package com.algorithim.datastructure.dynamicprogramming;

public class LongestCommonSubString {
    public int longestCommonSubString(String text1, String text2) {
        int max = 0;
        char[] textOneCharArray = text1.toCharArray();
        char[] textTwoCharArray = text2.toCharArray();
        int[][] temp = new int[textOneCharArray.length + 1][textTwoCharArray.length + 1];
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (textOneCharArray[i - 1] == textTwoCharArray[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                if (max < temp[i][j]) {
                    max = temp[i][j];
                    System.out.println(textOneCharArray[i-1]+" "+textTwoCharArray[j-1]);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        System.out.println(longestCommonSubString.longestCommonSubString("abcdef","bcdxyz"));
    }
}
