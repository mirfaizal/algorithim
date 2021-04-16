package com.algorithim.datastructure.dynamicprogramming;

public class SubSetSum {
    public static void main(String[] args) {
        System.out.println(hasSubSetSum(new int[] {2,3,7,8,10}, 11));
    }
    static boolean hasSubSetSum(int [] array, int sum){
        int n = array.length;
        boolean [][] dp = new boolean[n+1][sum + 1];
        for(int i=0;i<n+1;i++) dp[i][0] = true; // If I have array and sum = 0, can I have a sub set? -- Yes
        for(int i=1;i<sum+1;i++) dp[0][i] = false; // If I have empty array and sum = 1, 2, ... 11, can I have sub set ? -- No
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1; j++){
                if(array[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - array[i-1]] || dp[i-1][j];
                } else if(array[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
