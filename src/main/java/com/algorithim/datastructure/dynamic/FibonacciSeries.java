package com.algorithim.datastructure.dynamic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {

    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
        return dateFormat.format(new Date());
    }


    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        System.out.println(getDateTime());
        System.out.println(fibonacciSeries.fib(20));
        System.out.println(getDateTime());
        System.out.println(fibonacciSeries.fibMemoize(20));
        System.out.println(getDateTime());
        System.out.println(fibonacciSeries.fibBottomUp(20));
        System.out.println(getDateTime());
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

    public int fibBottomUp(int n){
        Map<Integer,Integer> map = new HashMap<>();
        Integer fib = 0;
        for(int i=0;i<=n;i++){
            if(i <= 0) {
                fib =  0;
            }else if(i == 1) {
                fib =  1;
            } else {
                fib = map.get(i-1) + map.get(i-2);
            }
            map.put(i,fib);
        }
        return map.get(n);
    }

    public String trimLeadingZero(String text){
        if(text.startsWith("0")) {
            return trimLeadingZero(text.substring(1));
        }
        return text;
    }
}
