package com.algorithim.datastructure.ik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *Given an integer array and a number k, find the k most frequent elements in the array.
 *
 * Example One
 * {
 * "arr": [1, 2, 3, 2, 4, 3, 1], => [1,2] [2,2] [3,2], [4,1]
 * "k": 2
 * }
 * Output:
 *
 * [3, 1]
 * Example Two
 * {
 * "arr": [1, 2, 1, 2, 3, 1],
 * "k": 1
 * }
 * Output:
 *
 * [1]
 * Notes
 * If multiple answers exist, return any.
 * The order of numbers in the output array does not matter.
 * Constraints:
 *
 * 1 <= length of the given array <= 3 * 105
 * 0 <= array element <= 3 * 105
 * 1 <= k <= number of unique elements in the array
 *
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        findTopKFrequentElements(Arrays.asList(1, 2, 1, 2, 3, 1,4,4,4,4,5,5,5),3).forEach(item -> System.out.print(item+" "));
    }
    static List<Integer> findTopKFrequentElements(List<Integer> arr, Integer k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        for(int i: arr) {
            frequencyMap.merge(i, 1, Integer::sum);
        }
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            queue.offer(entry.getKey());
            if(queue.size() > k) queue.poll();
        }
        return new ArrayList<>(queue);
    }
}
