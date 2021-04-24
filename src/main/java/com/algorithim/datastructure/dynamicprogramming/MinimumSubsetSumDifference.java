package com.algorithim.datastructure.dynamicprogramming;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        System.out.println(minimumSubsetSumDifference(new int[] {2,4,2,3}));
        System.out.println(minimumSubsetSumDifference(new int[] {3, 1, 4, 2, 2, 1}));
        System.out.println(minimumSubsetSumDifference(new int[] {1, 6, 11, 5}));

    }
    static int minimumSubsetSumDifference(int [] array){
        int sum = 0;
        for(int i=0;i< array.length;i++) sum += array[i];
        return subSetSumMinDifference(array,sum);
    }

    private static int subSetSumMinDifference(int[] array, int sum) {
        int n = array.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++) dp[i][0] = true;
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(array[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j <= sum / 2 ; j++){
            if(dp[n][j]) {
                int diff = sum - (2 * j);
                min = Math.min(min,diff);
            }
        }
        return min;
    }
}
