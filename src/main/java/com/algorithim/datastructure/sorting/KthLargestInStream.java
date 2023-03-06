package com.algorithim.datastructure.sorting;

import java.util.*;

public class KthLargestInStream {

    public static List<Integer> kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        // Write your code here
        Queue<Integer> minHeap = new PriorityQueue<>((a,b)-> a-b);
        List<Integer> result = new ArrayList<>();
        for(int initial : initial_stream) {
            minHeap.offer(initial);
            if(minHeap.size() > k) minHeap.poll();
        }
        for(int append : append_stream) {
            minHeap.offer(append);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            result.add(minHeap.peek());
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> result = kth_largest(4, Arrays.asList(4,6),Arrays.asList(5,2,20));
        System.out.println(result.get(0));
    }
}
