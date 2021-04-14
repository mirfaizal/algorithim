package com.algorithim.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below.
// More formally, if you are on index i on the current row,
// you may move to either index i or index i + 1 on the next row.
//        2
//        3 4
//        6 5 7
//        4 1 8 3
    public static void main(String[] args) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(Arrays.asList(2));
        outer.add(Arrays.asList(3,4));
        outer.add(Arrays.asList(6,5,7));
        outer.add(Arrays.asList(4,1,8,3));
        minimumTotal(outer);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int [][] dp = new int[rows][rows];
        // Base Case to calculate sum for each cell
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i<rows;i++){
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }
        for(int i = 2; i<rows;i++){
            for(int j=1;j<i;j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1] , dp[i-1][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        int col = 0;
        for(int i=0;i<rows;i++){
            if(min > dp[rows - 1][i]){
                min = dp[rows - 1][i];
                col = i;
            }
        }
        // Trace back the path
        int row = rows - 1;
        List<Integer> path = new ArrayList<>();
        path.add(triangle.get(row).get(col));
        while(row != 1){
            if(triangle.get(row-1).get(col - 1) < triangle.get(row-1).get(col)){
                col = col - 1;
            }
            path.add(triangle.get(row-1).get(col));
            row--;
        }
        path.add(triangle.get(0).get(0));
        System.out.println("Minimum path sum :"+min);
        System.out.println("Path :");
        Collections.reverse(path);
        for (int i : path) System.out.print(i+" -> ");
        return  min;
    }
}
