package com.algorithim.datastructure;

public class FibonacciSeries {
    public int fib(int n){
        System.out.println(n);
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    private int[] memo = new int[1001];
    public int fibMemoize(int n){
        System.out.println(memo[n]);
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(memo[n] == 0){
            memo[n] = fibMemoize(n - 1) + fibMemoize(n - 2);
        }
        return memo[n];
    }

    public String trimLeadingZero(String text){
        if(text.startsWith("0")){
            return trimLeadingZero(text.substring(1));
        }
        return text;
    }
}
