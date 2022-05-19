package com.algorithim.datastructure.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RateLimit {
    /**
     * 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
     * <p>
     * LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.
     * You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.
     * Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".
     * Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.
     * Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
     * <p>
     * Example 1:
     * <p>
     * Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
     * Output: ["daniel"]
     * Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40", "11:00").
     * Example 2:
     * <p>
     * Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
     * Output: ["bob"]
     * Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
     */
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        // Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"]
        //        keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
        // <daniel, [600,640,660]>
        // <luis, [540,660,780,900]>
        // DQ -> 660 - 600 ==> 60 remove from queue if more than equal to 60
        // size of queue >= 3 add key to list
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < keyName.length; i++){
            String [] values = keyTime[i].split(":");
            int time = Integer.parseInt(values[0]) * 60 + Integer.parseInt(values[1]);
            List<Integer> list = map.getOrDefault(keyName[i],new ArrayList<>());
            list.add(time);
            map.put(keyName[i],list);
        }
        for(Map.Entry<String, List<Integer>> entrySet : map.entrySet()){
            String key = entrySet.getKey();
            List<Integer> values = entrySet.getValue();
            Deque<Integer> queue = new ArrayDeque<>();
            for(Integer value : values){
                queue.offer(value);
                if(queue.getLast() - queue.peek() > 60){
                    queue.poll();
                }
                if(queue.size() >= 3){
                    result.add(key);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> defaulters = alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"});
        System.out.println(defaulters);
        defaulters = alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"});
        System.out.println(defaulters);
    }
}
