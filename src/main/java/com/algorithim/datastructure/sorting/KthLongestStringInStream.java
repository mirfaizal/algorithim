package com.algorithim.datastructure.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLongestStringInStream {
    private int k;
    private Queue<String> minHeap;
    KthLongestStringInStream(int k, String [] stream){
        this.k = k;
        this.minHeap = new PriorityQueue<>((a,b)-> isBigger(a,b));
        for(String str : stream){
            minHeap.offer(str);
            if(minHeap.size() > k) minHeap.poll();
        }
    }

    private int isBigger(String a, String b) {
        if(a.length() > b.length()) return 1;
        else if (a.length() < b.length()) return -1;
        return a.compareTo(b);
    }

    public String addStream(String [] stream){
        for(String str : stream){
            minHeap.offer(str);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthLongestStringInStream kthLongestStringInStream = new KthLongestStringInStream(3,new String[]{"A","B","C"});
        System.out.println(kthLongestStringInStream.addStream(new String[]{"AA","BBBB"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"CCCC"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"DDDD"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"D"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"C"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"AAAAAAAAAA"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"AAAAAAAAAB"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"AAAAAAAAAC"}));
        System.out.println(kthLongestStringInStream.addStream(new String[]{"AAAAAAAAAD"}));
        System.out.println();
    }
}
