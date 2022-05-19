package com.algorithim.datastructure.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        inner.add(new ArrayList<>(Arrays.asList(1,5)));
        inner.add(new ArrayList<>(Arrays.asList(6,8)));
        inner.add(new ArrayList<>(Arrays.asList(10,15)));
        inner.add(new ArrayList<>(Arrays.asList(14,20)));
        System.out.println(can_attend_all_meetings(inner));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 5}, {6, 8}, {10, 15}, {14, 20}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        Collections.sort(intervals, (a, b) -> (a.get(0) - b.get(0)));
        intervals.sort((o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));
        int item = intervals.get(0).get(1);
        for(int i = 1; i < intervals.size(); i++){
            if(item > intervals.get(i).get(0)) return 0;
            item = intervals.get(i).get(1);
        }
        return 1;
    }
}
