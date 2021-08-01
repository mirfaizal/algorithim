package com.algorithim.datastructure.sorting;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQ {
    public static void main(String[] args) {
        int [] result = sortUsingPriorityQueue(new int[] {6,3,4,2,5,1});
        for(int x : result) System.out.print(x+" ");
        System.out.println();
        Random rand = new Random();
        System.out.println(rand.nextInt((10+1) - 6) + 6);
    }

    private static int [] sortUsingPriorityQueue(int [] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length,(a,b)->(b-a));
        for(int i=0;i< arr.length;i++){
            if(queue.size() == 3){
                queue.poll();
            }
            queue.offer(arr[i]);
        }
        int [] result = new int[arr.length];
        int index = 0;
        while(!queue.isEmpty()){
            result[index++] = queue.poll();
        }
        return result;
    }

}