package com.algorithim.datastructure.backtracking;

import java.util.ArrayList;
import java.util.List;


public class NQueen {

    public static void main(String[] args) {
        solveNQueens(4);
    }

    private static List<List<Integer>> results = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        solveNQueensHelper(0,n,new ArrayList<>());
        List<List<Integer>> result = results;
        return new ArrayList<>();
    }
    private static void solveNQueensHelper(int index, int n, List<Integer> slate){
        // Backtracking case
        // Detect conflict b/w queen(i-1) and earlier
        int lastQueen = slate.size() - 1;
        for(int earlierQueen=0; earlierQueen<lastQueen - 1; earlierQueen++){
            // Column conflict
            if(slate.get(earlierQueen) == slate.get(lastQueen)) return;
            // Diagonal conflict
            int rowDiff = Math.abs(earlierQueen - lastQueen);
            int colDiff = Math.abs(slate.get(earlierQueen) - slate.get(lastQueen));
            if(rowDiff == colDiff) return;
        }

        // Base Case
        if(index == n){
            results.add(new ArrayList<>(slate));
            return;
        }

        // Recursive Case
        for(int col=0; col<n;col++){
            // Queen to be placed in col
            slate.add(col);
            solveNQueensHelper(col+1,n,slate);
            slate.remove(slate.size()-1);
        }

    }
}

