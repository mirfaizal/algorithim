package com.algorithim.datastructure.sorting;

import java.util.*;

public class KthBiggestStringInStream {
    private int k;
    private Queue<String> minHeap;
    KthBiggestStringInStream(int k, String [] stream){
        this.k = k;
        this.minHeap = new PriorityQueue<>(String::compareTo);
        for(String str : stream){
            minHeap.offer(str);
            if(minHeap.size() > k) minHeap.poll();
        }
    }
    public String addStream(String [] stream){
        for(String str : stream){
            minHeap.offer(str);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthBiggestStringInStream kthBiggestStringInStream = new KthBiggestStringInStream(3,new String[]{"A","B","C"});
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"AA","BBBB"}));
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"CCCC"}));
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"DDDD"}));
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"D"}));
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"C"}));
        System.out.println(kthBiggestStringInStream.addStream(new String[]{"AAAAAAAAAA"}));
        System.out.println("AAAAA".compareTo("C"));
        System.out.println("AAAAA".compareTo("C"));
    }
}
