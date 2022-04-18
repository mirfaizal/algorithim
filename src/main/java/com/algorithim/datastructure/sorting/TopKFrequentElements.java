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
        return new ArrayList<>(queue);

    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        ArrayList<Integer> result = topKFrequentElements.find_top_k_frequent_elements(new int [] {4, 4, 3, 5, 5, 1}, 2);
        System.out.println();
    }
}
