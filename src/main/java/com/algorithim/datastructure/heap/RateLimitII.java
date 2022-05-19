package com.algorithim.datastructure.heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class RateLimitII {
    int limit;
    int window; // In seconds
    Map<String, Deque<Integer>> rateLimitMap = new TreeMap<>();
    RateLimitII(int limit, int window){
        this.limit = limit;
        this.window = window;
    }
    // rateLimiter("api1","10:10:35")
    public boolean rateLimiter(String key, String time){
        String [] timeValues = time.split(":");
        Integer second = Integer.parseInt(timeValues[0]) * 60 * 60 + Integer.parseInt(timeValues[1]) * 60 + Integer.parseInt(timeValues[2]);
        Deque<Integer> values = rateLimitMap.get(key);
        if(!rateLimitMap.containsKey(key)){
            Deque<Integer> list = new ArrayDeque<>();
            list.offer(second);
            rateLimitMap.put(key,list);
        } else {
            boolean limited = false;
            values.offer(second);
            rateLimitMap.put(key,values);
            Deque<Integer> queue = new ArrayDeque<>();
            for(Integer value : values){
                queue.add(value);
                if(second - queue.peek() > this.window){
                    queue.poll();
                }
                if(queue.size() > this.limit){
                    limited =  true;
                    break;
                }
            }
            if(limited){
                values.poll();
                return false;
            }
            for(Integer value : values) {
                if (second - values.peek() > this.window) {
                    values.poll();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RateLimitII rateLimitII = new RateLimitII(3,60);
        System.out.println(rateLimitII.rateLimiter("api1","10:00:01"));
        System.out.println(rateLimitII.rateLimiter("api1","10:00:30"));
        System.out.println(rateLimitII.rateLimiter("api1","10:00:59"));
        System.out.println(rateLimitII.rateLimiter("api1","10:01:00"));
        System.out.println(rateLimitII.rateLimiter("api1","10:01:01"));
        System.out.println(rateLimitII.rateLimiter("api1","10:01:02"));
        System.out.println(rateLimitII.rateLimiter("api1","10:01:03"));

        System.out.println(rateLimitII.rateLimiter("api1","10:02:03"));
        System.out.println(rateLimitII.rateLimiter("api1","10:02:04"));
        System.out.println(rateLimitII.rateLimiter("api1","10:02:30"));
        System.out.println(rateLimitII.rateLimiter("api1","10:02:59"));

        System.out.println(rateLimitII.rateLimiter("api1","10:03:00"));
        System.out.println(rateLimitII.rateLimiter("api1","10:03:00"));
        System.out.println(rateLimitII.rateLimiter("api1","10:03:00"));
        System.out.println(rateLimitII.rateLimiter("api1","10:03:01"));

    }
}
