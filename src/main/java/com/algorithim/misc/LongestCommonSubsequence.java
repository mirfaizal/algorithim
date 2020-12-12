package com.algorithim.misc;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int max = 0;
        char[] textOneCharArray = text1.toCharArray();
        char[] textTwoCharArray = text2.toCharArray();
        int temp[][] = new int[textOneCharArray.length + 1][textTwoCharArray.length + 1];
        for (int i = 1; i < textOneCharArray.length + 1; i++) {
            for (int j = 1; j < textTwoCharArray.length + 1; j++) {
                if (textOneCharArray[i - 1] == textTwoCharArray[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
                if (max < temp[i][j]) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }
}
