package com.algorithim.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result.size());
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> outer = new ArrayList<>();
        if(n == 0) return outer;
        int [][] dp = new int [n][n];
        //Base Case
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        outer.add(Arrays.asList(1));
        outer.add(Arrays.asList(1,1));

        // Recurrence Case
        for(int i = 2; i < n; i++) {
            List<Integer> inner = new ArrayList<>();
            inner.add(dp[i][0]);
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                inner.add(dp[i][j]);
            }
            inner.add(dp[i][i]);
            outer.add(inner);
        }
        return outer;
    }
}
