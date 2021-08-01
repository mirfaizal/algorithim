package com.algorithim.datastructure.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class MeetingRoom {
//    Given a list of meeting intervals where each interval consists of a start and an end time,
//    check if a person can attend all the given meetings such that only one meeting can be attended at a time.
//    Example One
//    Input = [[1, 5], [5, 8], [10, 15]]
//    Output = 1
//    As the above intervals are non-overlapping intervals, it means a person can attend all these meetings.
//    Example Two
//    Input = [[1, 5], [4, 8]]
//    Output = 0
//    Time 4 - 5 is overlapping in the first and second intervals.

    public static void main(String[] args) {
        List<List<Integer>> inner = new ArrayList<>();
        Map<Integer,Integer> map = new WeakHashMap<>();
        map.get(1);
        inner.add(new ArrayList<>(Arrays.asList(1,5)));
        inner.add(new ArrayList<>(Arrays.asList(6,8)));
        inner.add(new ArrayList<>(Arrays.asList(10,15)));
        System.out.println(can_attend_all_meetings(inner));
    }
    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        Collections.sort(intervals, Comparator.comparing(o -> o.get(0)));
        //Collections.sort(intervals, (o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        int item = intervals.get(0).get(1);
        for(int i = 1; i < intervals.size(); i++){
            if(item > intervals.get(i).get(0)) return 0;
            item = intervals.get(i).get(1);
        }
        return 1;
    }

    public static int can_attend_all_meetings1(List<List<Integer>> intervals) {

        Collections.sort(intervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if(intervals.size() <= 1) return 1;
        int item = intervals.get(0).get(1);
        for(int i=1;i<intervals.size();i++){
            if(item > intervals.get(i).get(0)) return 0;
            item = intervals.get(i).get(1);
        }
        return 1;
    }

}
