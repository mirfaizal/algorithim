package com.algorithim.datastructure.dynamicprogramming;

public class Knapsack01 {
    // Recursion
    static int knapsack(int[] weight, int[] value, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (weight[n - 1] <= w) {
            return Math.max(value[n - 1] + knapsack(weight, value, w - weight[n - 1], n - 1), knapsack(weight, value, w, n - 1));
        } else {
            return knapsack(weight, value, w, n - 1);
        }
    }
    // Top Down Memoization
    static int memo_knapsack(int[] weight, int[] value, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (memo[n][w] != -1) return memo[n][w];
        if (weight[n - 1] <= w) {
            memo[n][w] = Math.max(value[n - 1] + knapsack(weight, value, w - weight[n - 1], n - 1), knapsack(weight, value, w, n - 1));
        } else {
            memo[n][w] = knapsack(weight, value, w, n - 1);
        }
        return memo[n][w];
    }
    // Bottom Up
    private static int bottomUpKnapsack(int[] weights, int[] profits, int knapsack) {
        int[][] dp = new int[weights.length + 1][knapsack + 1];
        // Base Case or Initialize table
        for (int i = 0; i < weights.length + 1; i++) dp[i][0] = 0; // If weight is zero, then maximum profit is 0
        for (int i = 0; i < knapsack + 1; i++) dp[0][i] = 0; // If knapsack is zero, then maximum profit is 0
        // Recursive case --> Iterative in DP
        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < knapsack + 1; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][knapsack];
    }
    static int[][] memo;
    public static void main(String[] args) {
        int[] profits = {10,20,30,-1000,1000};
        int[] weights = {1, 2, 3, 4, 5};
        int knapsack = 3;

        System.out.println(knapsack(weights, profits, knapsack, weights.length));
        System.out.println(knapsack(weights, profits, knapsack - 1, weights.length));

        memo = new int[weights.length + 1][knapsack + 1];
        for (int i = 0; i < weights.length + 1; i++) for (int j = 0; j < knapsack + 1; j++) memo[i][j] = -1;
        System.out.println(memo_knapsack(weights, profits, knapsack, weights.length));

        System.out.println(bottomUpKnapsack(weights, profits, knapsack));
        System.out.println(bottomUpKnapsack(weights, profits, knapsack - 1));
    }

}
