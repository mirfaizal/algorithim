package com.algorithim.datastructure.dynamicprogramming;

public class PaintHouse {
//    There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
//    The cost of painting each house with a certain color is different.
//    You have to paint all the houses such that no two adjacent houses have the same color.
//    The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
//
//    For example, costs[0][0] is the cost of painting house 0 with the color red;
//    costs[1][2] is the cost of painting house 1 with color green, and so on...
//    Return the minimum cost to paint all houses.
//
//    Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
//    Output: 10
//    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//    Minimum cost: 2 + 5 + 3 = 10.

    public static void main(String[] args) {
        //[[5,8,6],[19,14,13],[7,5,12],[14,15,17],[3,20,10]]
        System.out.println("Minimum cost:" +minCost(new int[][]{{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}}));
        System.out.println("Minimum cost:" +minCost(new int[][]{{17,2,17}, {16,16,5},{14,3,19}}));
    }
    public static int minCost(int[][] costs) {
        int numberOfColors = costs[0].length;
        int numberOfHouses = costs.length;
        int RED = 0, BLUE = 1, GREEN = 2;
        int [][] dp = new int[numberOfHouses][numberOfColors];
        for(int i=0;i<numberOfColors;i++) dp[0][i] = costs[0][i];
        for(int i = 1; i <numberOfHouses; i++ ){
            dp[i][RED] = costs[i][RED] + Math.min(dp[i-1][BLUE],dp[i-1][GREEN]);
            dp[i][BLUE] = costs[i][BLUE] + Math.min(dp[i-1][RED],dp[i-1][GREEN]);
            dp[i][GREEN] = costs[i][GREEN] + Math.min(dp[i-1][BLUE],dp[i-1][RED]);
        }
        int min = Integer.MAX_VALUE;
        int min_col = 0;
        for(int i = 0; i <numberOfColors; i++ ){
            if(min > dp[numberOfHouses - 1][i]){
                min = dp[numberOfHouses - 1][i];
                min_col = i;
            }
        }
        return min;
    }

    private int[][] costs;
    public int minCostRecursion(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        return totalCost;
    }
}
