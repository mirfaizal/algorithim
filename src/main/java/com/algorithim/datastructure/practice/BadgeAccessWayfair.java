package com.algorithim.datastructure.practice;

/*
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often.
We have an unordered list of names and entry times over a single day.
Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period.
Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period.
If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"],
];

// <"Paul" ,[1315,1355,1405,1416]>
//
// Dubly Queue

//  Time - O(nlogn) + O(n) + O(nk logk) =>> O(nlogn)
// Space - O(n) + O(n) ==> O(n)


Expected output (in any order)
   Paul: 1315 1355 1405
   Jose: 830 835 855 915 930
   Zhang: 10 109 110
   Amos: 500 503 504

n: length of the badge records array
*/

import java.util.*;

public class BadgeAccessWayfair {

    private static Map<String, List<String>> badgeDefaulter(String [][] badgeTimes){
        // Sort based on times
        Arrays.sort(badgeTimes, (a,b) -> (Integer.parseInt(a[1]) - Integer.parseInt(b[1])));
        // Building the map
        Map<String, List<String>> employeeMap = new HashMap<>();
        for(String [] badge : badgeTimes){
            String key = badge[0];
            String value = badge[1];
            List<String> list = employeeMap.getOrDefault(key,new ArrayList<>());
            list.add(value);
            employeeMap.put(key, list);
        }
        Map<String, List<String>> defaulterMap = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : employeeMap.entrySet()){
            String key = entry.getKey();
            List<String> values =  entry.getValue();
            Deque<String> queue = new ArrayDeque<>();
            for(String time : values){
                queue.offer(time);
                int currentTime = getTime(queue.peek());
                int lastTime = getTime(queue.getLast());
                if(lastTime - currentTime > 60) {
                    queue.poll();
                }
                if(queue.size() >= 3){
                    // add to final list
                    List<String> list = new ArrayList<>();
                    while(!queue.isEmpty()) list.add(queue.poll());
                    if(!defaulterMap.containsKey(key)){
                        defaulterMap.put(key, list);
                    }
                }
            }

        }
        return defaulterMap;
    }

    private static int getTime(String time){
        int hour;
        int min;
        if(time.length() <= 2){
            return Integer.parseInt(time);
        } else {
            hour =  Integer.parseInt(time.substring(0,time.length() - 2));
            min =  Integer.parseInt(time.substring(time.length() - 2));
        }
        return hour * 60 + min;
    }

    public static void main(String[] argv) {
        String[][] badgeTimes = new String[][] {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"Jose", "835"},
                {"Jose", "830"},
                {"Paul", "1315"},
                {"Chloe", "0"},
                {"Chloe", "1910"},
                {"Jose", "1615"},
                {"Jose", "1640"},
                {"Paul", "1405"},
                {"Jose", "855"},
                {"Jose", "930"},
                {"Jose", "915"},
                {"Jose", "730"},
                {"Jose", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"Jose", "1630"},
                {"Jennifer", "5"},
                {"Chloe", "1909"},
                {"Zhang", "1"},
                {"Zhang", "10"},
                {"Zhang", "109"},
                {"Zhang", "110"},
                {"Amos", "1"},
                {"Amos", "2"},
                {"Amos", "400"},
                {"Amos", "500"},
                {"Amos", "503"},
                {"Amos", "504"},
                {"Amos", "601"},
                {"Amos", "602"},
                {"Paul", "1416"},
        };
        Map<String, List<String>> result = badgeDefaulter(badgeTimes);
        System.out.println(result);
    }
}

