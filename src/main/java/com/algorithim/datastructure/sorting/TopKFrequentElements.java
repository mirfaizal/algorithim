package com.algorithim.datastructure.sorting;

// Given an integer array and a number k, find the k most frequent elements in the array.
//
// Example One
// {
// "arr": [1, 2, 3, 2, 4, 3, 1],
// "k": 2
// }
// Output:
//
// [3, 1]
// Example Two
// {
// "arr": [1, 2, 1, 2, 3, 1],
// "k": 1
// }
// Output:
//
// [1]

import java.util.*;

public class TopKFrequentElements {
    private Map<Integer,Integer> frequencyMap = new HashMap<>();
    private ArrayList<Integer> find_top_k_frequent_elements(int[] arr, Integer k) {
        Queue<Integer> queue  = new PriorityQueue<>((o1, o2) -> frequencyMap.get(o1) - frequencyMap.get(o2));
        for(Integer i : arr){
            frequencyMap.merge(i, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            queue.offer(entry.getKey());
            if(queue.size() > k) queue.poll();
        }
        Integer numbers[] = new Integer[] { 10, 20, 30, 40 };
        List<Integer> list = Arrays.asList(numbers);
        xx(list);
        List<String> countriesList = Collections.unmodifiableList(new ArrayList<>());

        list.get(0);
        return new ArrayList(queue);

    }

    public static int method1() {
        int value = 1;
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch(ArrayIndexOutOfBoundsException e){
            value = 2;
            return value;
        }finally{
            value += 2;
            return value;
        }

    }

    private void xx(List<Integer> list) {
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        List<Integer> result = topKFrequentElements.find_top_k_frequent_elements(new int [] {4, 4, 3, 5, 5, 1}, 2);
        System.out.println();
    }
}
