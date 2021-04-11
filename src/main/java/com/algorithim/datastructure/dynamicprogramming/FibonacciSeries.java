package com.algorithim.datastructure.dynamicprogramming;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {

    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
        return dateFormat.format(new Date());
    }

    private static Map<Double, Double> map = new HashMap<Double, Double>();
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
//        System.out.println(getDateTime());
//        System.out.println(fibonacciSeries.fib(20));
        System.out.println(getDateTime());

        map.put(0D, 0D);
        map.put(1D, 1D);

        System.out.println(fibonacciSeries.fibBottomUp(1000));
        System.out.println(getDateTime());
//        System.out.println(fibonacciSeries.fibBottomUp(20));
//        System.out.println(getDateTime());
    }

    public int fib(int n){
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    private final int[] memo = new int[1001];
    public Integer fibMemoize(int n){
        if(n <= 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else if(memo[n] == 0){
            memo[n] = fibMemoize(n - 1) + fibMemoize(n - 2);
        }
        return memo[n];
    }



    public double fibBottomUp(double n){
        // Base Case
        if(map.containsKey(n)){
            return map.get(n);
        }
        map.put(n,fibBottomUp(n-1) + fibBottomUp(n-2));
        return map.get(n);
    }

    public String trimLeadingZero(String text){
        if(text.startsWith("0")) {
            return trimLeadingZero(text.substring(1));
        }
        return text;
    }
}
