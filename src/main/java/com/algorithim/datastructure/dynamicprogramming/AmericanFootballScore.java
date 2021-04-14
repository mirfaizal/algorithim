package com.algorithim.datastructure.dynamicprogramming;

public class AmericanFootballScore {

    public static void main(String[] args) {
        System.out.println(countAmericanFootballScore(8));
        System.out.println(countAmericanFootballScoreOptimized(8));
    }

    static int  countAmericanFootballScore(int finalScore){
        // Score [2,3,6]
        // total = f(n-2) + f(n-3) + f(n-6)
        int array [] = new int[finalScore + 1];
        array[0] = 1;
        for(int i=1;i<=finalScore;i++){
            array[i] = (i>=2?array[i-2]:0) + (i>=3?array[i-3]:0) + (i>=6?array[i-6]:0) ;
        }
        return array[finalScore];
    }

    static int  countAmericanFootballScoreOptimized(int finalScore){
        // Score [2,3,6]
        // total = f(n-2) + f(n-3) + f(n-6)
        int array [] = new int[6];
        array[0] = 1;
        for(int i=1;i<=array.length;i++){
            array[i % 6] = (i>=2?array[(i-2) % 6]:0) + (i>=3?array[(i-3)  % 6]:0) + (i>=6?array[(i-6)  % 6]:0) ;
        }
        return array[finalScore % 6];
    }
}
