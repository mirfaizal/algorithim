package com.algorithim.datastructure.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    public static void main(String[] args) {
        find_intersection(new ArrayList<>(Arrays.asList(2,5,10)),new ArrayList<>(Arrays.asList(2,3,4,10)),new ArrayList<>(Arrays.asList(2,4,10)));
    }

    public static List<Integer> find_intersection(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) == b.get(j)) {
                result.add(a.get(i));i++; j++;
            }
            else if (a.get(i) > b.get(j)) j++;
            else i++;
        }
        i = 0;
        List<Integer> finalA = new ArrayList<>();
        while(i < c.size() && k < result.size()){
            if(c.get(i) == result.get(k)) {
                finalA.add(c.get(i));i++; k++;
            }
            else if (c.get(i) > result.get(k)) k++;
            else i++;
        }
        if(finalA.isEmpty()) finalA.add(-1);
        return finalA;
    }
}
