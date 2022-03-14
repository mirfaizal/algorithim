package com.algorithim.datastructure.sorting;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQ {
    public static void main(String[] args) {
        int [] result = sortUsingPriorityQueue(new int[] {6,3,4,2,5,1});
        for(int x : result) System.out.print(x+" ");
    }

    private static int [] sortUsingPriorityQueue(int [] arr){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i< arr.length;i++){
            maxHeap.offer(arr[i]);
            minHeap.offer(arr[i]);
            if(maxHeap.size() == 10){
                maxHeap.poll();
                minHeap.poll();
            }
        }
        int [] result = new int[arr.length];
        int index = 0;
        while(!maxHeap.isEmpty()){
            result[index++] = maxHeap.poll();
        }
        return result;
    }

}