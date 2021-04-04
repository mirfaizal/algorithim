package com.algorithim.datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(3);
        list.add(11);
        list.add(6);
        list.add(5);
        two_sum(list,8);
    }

    public static List<Integer> two_sum(List<Integer> numbers, int target) {

        // Approach 1
        // Using HashTable O(n)
        // List<Integer> list = new ArrayList<>();
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0 ; i< numbers.size(); i++){
        //     int difference = target - numbers.get(i);
        //     if(map.containsKey(difference)){
        //         list.add(map.get(difference));
        //         list.add(i);
        //         break;
        //     }
        //     map.put(numbers.get(i),i);
        // }
        // if(list.size() == 0){
        //     list.add(-1);
        //     list.add(-1);
        // }
        // return list;
        // Approach 2
        // Sort array and use 2 pointer approach O(nlogn + n)
        List<Integer> list = new ArrayList<>();
        Collections.sort(numbers);
        for(int k : numbers) System.out.print(k+" ");
        int i=0, j=numbers.size() - 1;
        while(i<j){
            if(numbers.get(i) + numbers.get(j) == target) {
                list.add(i);
                list.add(j);
                break;
            } else if(numbers.get(i) + numbers.get(j) > target) {
                j--;
            } else if(numbers.get(i) + numbers.get(j) < target) {
                i++;
            }
        }
        if(list.size() == 0){
            list.add(-1);
            list.add(-1);
        }
        return list;
    }
}
