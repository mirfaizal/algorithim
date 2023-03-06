package com.algorithim.datastructure.heap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * We are working on a security system for a badged-access room in our company's building.
 *
 * We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day.
 * Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".
 *
 * Write a function that finds anyone who badged into the room three or more times in a one-hour period.
 * Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period.
 * If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.
 *
 * badge_record = [
 * ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
 * ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
 * ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
 * ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
 * ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
 * ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
 * ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
 * ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
 * ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
 * ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
 * ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"],
 * ];
 *
 * n: length of the badge records array
 *
 * Expected output (in any order)
 * Paul: 1315 1355 1405
 * Jose: 830 835 855 915 930
 * Zhang: 10 109 110
 * Amos: 500 503 504
 */

public class BadgedAccess {


    private static Map<String, List<String>> getDefaulterList(List<EmployeeAccess> list) {
        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a.timestamp)));
        Map<String, List<String>> employeeMap = new TreeMap<>();
        Map<String, List<String>> defaulter = new TreeMap<>();
        for(EmployeeAccess employeeAccess : list){
            List<String> empTimeList = employeeMap.getOrDefault(employeeAccess.name, new ArrayList<>());
            empTimeList.add(employeeAccess.timestamp);
            employeeMap.put(employeeAccess.name,empTimeList);
        }
        for(Map.Entry<String,List<String>> entrySet : employeeMap.entrySet()){
            String employeeName = entrySet.getKey();
            List<String> timeList = entrySet.getValue();
            Deque<String> deque = new ArrayDeque<>();
            for(String time : timeList){
                deque.offer(time);
                assert deque.peek() != null;
                int currentTime = getCurrentTime(deque.peek());
                int lastTime = getCurrentTime(deque.getLast());
                if(lastTime - currentTime >= 60){
                    deque.poll();
                }
                if(deque.size() >= 3){
                    List<String> times = new ArrayList<>();
                    while(!deque.isEmpty()) times.add(deque.poll());
                    defaulter.put(employeeName, times);
                }
            }
        }
        return defaulter;
    }

    private static int getCurrentTime(String time) {
        String currentMinute;
        String currentHour;
        if(time.length() <= 2){
            currentMinute = time;
        } else {
            currentHour = time.substring(0, time.length() - 2);
            currentMinute = time.substring(time.length() - 2);
            return Integer.parseInt(currentHour) * 60 + Integer.parseInt(currentMinute);
        }
        return Integer.parseInt(currentMinute);
    }

    static class EmployeeAccess {
        String name;
        String timestamp;

        EmployeeAccess(String name, String timestamp) {
            this.name = name;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        List<EmployeeAccess> list = Arrays.asList(new EmployeeAccess("Paul", "1355"),
                new EmployeeAccess("Jennifer", "1910"),
                new EmployeeAccess("Jose", "835"),
                new EmployeeAccess("Jose", "830"),
                new EmployeeAccess("Paul", "1315"),
                new EmployeeAccess("Chloe", "0"),
                new EmployeeAccess("Chloe", "1910"),
                new EmployeeAccess("Jose", "1615"),
                new EmployeeAccess("Jose", "1640"),
                new EmployeeAccess("Paul", "1405"),
                new EmployeeAccess("Jose", "855"),
                new EmployeeAccess("Jose", "930"),
                new EmployeeAccess("Jose", "915"),
                new EmployeeAccess("Jose", "730"),
                new EmployeeAccess("Jose", "940"),
                new EmployeeAccess("Jennifer", "1335"),
                new EmployeeAccess("Jennifer", "730"),
                new EmployeeAccess("Jose", "1630"),
                new EmployeeAccess("Jennifer", "5"),
                new EmployeeAccess("Chloe", "1909"),
                new EmployeeAccess("Zhang", "100"),
                new EmployeeAccess("Zhang", "105"),
                new EmployeeAccess("Zhang", "109"),
                new EmployeeAccess("Zhang", "110"),
                new EmployeeAccess("Amos", "1"),
                new EmployeeAccess("Amos", "2"),
                new EmployeeAccess("Amos", "400"),
                new EmployeeAccess("Amos", "500"),
                new EmployeeAccess("Amos", "503"),
                new EmployeeAccess("Amos", "504"),
                new EmployeeAccess("Amos", "601"),
                new EmployeeAccess("Amos", "602"),
                new EmployeeAccess("Paul", "1416"));
        Map<String, List<String>> defaulter = getDefaulterList(list);
        System.out.println(defaulter);
    }


}
