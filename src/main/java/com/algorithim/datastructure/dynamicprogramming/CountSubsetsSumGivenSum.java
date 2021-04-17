package com.algorithim.datastructure.dynamicprogramming;

public class CountSubsetsSumGivenSum {

//    Count of subsets sum with a Given sum
//    Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
//    Example:
//    Input: arr[] = {1, 2, 3, 3}, X = 6
//    Output: 3
//    All the possible subsets are {1, 2, 3},
//    {1, 2, 3} and {3, 3}

    public static void main(String[] args) {
        int [] arr = new int[]{1,5,11,5};
        int sum = 11;

        System.out.println(countSubSetSumGivenSum(arr,sum, 0));
        memo = new int[arr.length + 1][sum + 1];
        for(int i=0; i< arr.length + 1; i++)
            for(int j=0;j<sum+1;j++)
                memo[i][j] = -1;
        System.out.println(countSubSetSumGivenSum_memo(arr,sum, 0));
        System.out.println(countSubSetSumGivenSum_dp(arr,sum));

    }
    public static int countSubSetSumGivenSum(int [] arr, int sum, int n){
        if(n== arr.length){
            if(sum == 0) return 1;
            else return 0;
        }
        return countSubSetSumGivenSum(arr,sum - arr[n] , n+1) + countSubSetSumGivenSum(arr,sum , n+1);
    }
    static int [][] memo;
    public static int countSubSetSumGivenSum_memo(int [] arr, int sum, int n){
        if(n== arr.length){
            if(sum == 0) return 1;
            else return 0;
        }
        if(memo[n][sum] != -1) return memo[n][sum];
        memo[n][sum] = countSubSetSumGivenSum(arr,sum - arr[n] , n+1) + countSubSetSumGivenSum(arr,sum , n+1);
        return memo[n][sum];
    }

    public static int countSubSetSumGivenSum_dp(int [] arr, int sum){
        int n = arr.length;
        int [][] dp = new int[n + 1][sum + 1];
        for(int i=0;i<n+1;i++) dp[i][0] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=1;i<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
