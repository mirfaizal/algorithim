package com.algorithim.datastructure.companies.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Average {

//    Question 1:
//    Given a 2-D String array of student-marks find the student with the highest average and output his average score. If the average is in decimals, floor it down to the nearest integer.
//    Example 1:
//    Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
//    Output: 99
//    Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.

    public static void main(String[] args) {
        List<List<String>> studentMarks = new ArrayList<>();
        studentMarks.add(Arrays.asList("Bob", "87"));
        studentMarks.add(Arrays.asList("Mike", "35"));
        studentMarks.add(Arrays.asList("Bob", "52"));
        studentMarks.add(Arrays.asList("Jason", "35"));
        studentMarks.add(Arrays.asList("Mike", "55"));
        studentMarks.add(Arrays.asList("Jessica", "99"));
        System.out.println(findAvg(studentMarks));
    }

    private static String findAvg(List<List<String>> studentMarks) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<studentMarks.size();i++){
            List<String> tuple = studentMarks.get(i);
            String name = tuple.get(0);
            String marks = tuple.get(1);
            Integer marksInt = Integer.parseInt(marks);
            if(map.get(name) == null){
                map.put(name,marksInt);
            } else {
                Integer previousMarks = map.get(name);
                previousMarks += marksInt;
                previousMarks /= 2;
                map.put(name,previousMarks);
            }
        }
        int max = Integer.MIN_VALUE;
        String name = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                name = entry.getKey();
            }
            max = Math.max(max, entry.getValue());
        }
        return name;
    }
}
