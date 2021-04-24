package com.algorithim.datastructure.dynamicprogramming;

public class EqualSumPartition {
    public static void main(String[] args) {
        System.out.println(equalSubSetPartition(new int[] {1,5,11,5,2}));
    }
    static boolean equalSubSetPartition(int [] array){
        int sum = 0;
        for(int i=0;i< array.length;i++) sum += array[i];
        int max = 0;
        for(int i=0;i< array.length;i++) {
            max = Math.max(max,array[i]);
        }
        if(sum % 2 != 0) return false;
        if(max > sum) {
            return subSetSum(array,max);
        }
        else return subSetSum(array,sum);
    }
    private static boolean subSetSum(int[] array, int w) {
        int n = array.length;
        boolean [][] dp = new boolean[n + 1][w + 1];
        for(int i=0;i< n + 1; i++) dp[i][0] = true; // If we have array {} , {1...n} and sum is 0, we can still make the sum = 0 without taking any items.
        for(int i=1;i< w + 1; i++) dp[0][i] = false; // If we have empty array and sum is 1,2,3...n, we cant make the sum.
        for(int i=1;i< n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(array[i - 1] <= j) {
                    dp[i][j] = dp[i-1][Math.abs(j - Math.abs(array[i-1]))] || dp[i-1][j];
                } else if(array[i - 1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    private static boolean subSetSum_Using2Rows(int[] array, int w) {
        boolean [][] dp = new boolean[2][w + 1];
        for(int i=0;i< 2; i++) dp[i][0] = true; // If we have array {} , {1...n} and sum is 0, we can still make the sum = 0 without taking any items.
        //for(int i=1;i< w + 1; i++) dp[0][i] = false; // If we have empty array and sum is 1,2,3...n, we cant make the sum.
        for(int i=1;i< 2; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(array[i - 1] <= j) {
                    dp[i & 1][j] = dp[(i - 1) & 1][Math.abs(j - Math.abs(array[i-1]))] || dp[(i - 1) & 1][j];
                } else if(array[i - 1] > j) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j];
                }
            }
        }
        return dp[2 & 1][w];
    }
}
