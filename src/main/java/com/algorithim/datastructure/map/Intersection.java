package com.algorithim.datastructure.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Intersection {

    public static void main(String[] args) {
        int [] array1 = new int [] {1,1,1,2,2,1,3};
        int [] array2 = new int [] {1,2,2,2,2,3,3,1};
        int [] result1 = intersectingMapI(array1, array2);
        for(int i=0;i<result1.length;i++) System.out.print(result1[i]+" ");
        int [] result = intersect(array1, array2);
        for(int i=0;i<result.length;i++) System.out.print(result[i]+" ");
    }

    private static int[] intersect(int[] array1, int[] array2) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<array1.length;i++){
            map.put(array1[i], map.getOrDefault(array1[i],0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<array2.length;i++){
            int count = map.getOrDefault(array2[i],0);
            if(count > 0){
                map.put(array2[i], --count);
                list.add(array2[i]);
            }
        }
        int [] array = new int[list.size()];
        int index = 0;
        for(int i: list) array[index++] = i;
        return array;
    }

    private static int [] intersectingMapI(int[] array1, int[] array2) {
        Map<Integer, Integer> map1 = intersectWithMap(array1, array2);
        Map<Integer, Integer> map2 = intersectWithMap(array2, array1);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
            for(int i = 0 ; i<count;i++) list.add(entry.getKey());
        }
        int [] array = new int[list.size()];
        int index = 0;
        for(int i: list) array[index++] = i;
        return array;
    }

    public static Map<Integer, Integer> intersectWithMap(int[] nums1, int[] nums2) {
        Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
        Set<Integer> set;
        for(int i=0;i<nums1.length;i++) {
            for(int j = 0; j< nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    if(map.containsKey(nums1[i])) {
                        set = map.get(nums1[i]);
                    } else {
                        set = new HashSet<>();
                    }
                    set.add(j);
                    map.put(nums1[i],set);
                }
            }
        }
        Map<Integer, Integer> map1 = new LinkedHashMap<>();

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            int count = 0;
            for(int i : entry.getValue()) count ++;
            map1.put(entry.getKey(),count);
        }
        return map1;
    }
}
