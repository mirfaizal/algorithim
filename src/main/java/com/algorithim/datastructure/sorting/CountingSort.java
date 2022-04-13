package com.algorithim.datastructure.sorting;
import java.util.*;
public class CountingSort {

}


// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

/*
Given an integer array with many duplicated elements, write an algorithm to efficiently sort it in linear time. All numbers are positive and max value of an element can be k

Input: [4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 500 ], k

Output: [ 1, 1, 2, 2, 4, 4, 10, 10, 10, 40, 500 ]

*/

/*
Input [4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 500 ], 1000000

[4,2]
[0,0]
[1,2]
[2,2]


for(o->K){
get(i)
}

[1 1 4 4]




*/



/*

Given the head of a linked list, return the list after sorting it in ascending order.

Input: head = 4 —> 2 —> 1 —> 3
Output: 1 —> 2 —> 3 —> 4

split()
merge()
sort()

Definition for singly-linked list.
public class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

*/



class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        //sort();
    }
    // [4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 500] , k = 500
    public static int[] sort(int [] arr, int k){
        if(arr.length <= 1) return arr;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.merge(i,1,Integer::sum);
        }
        // Time = O(n) + o(K)
        // Space = O(n)
        // 0 to k

        // <4, 2>
        // <2, 2>
        // <40, 1>
        // <10, 3>
        // <1, 2>
        // <500, 1>
        int [] result = new int[arr.length];

        int index = 0;
        for(int i = 0; i<=k ; i++){
            int frequency = map.getOrDefault(i,0);
            while(frequency > 0){
                result[index++] = i;
                frequency--;
            }
            // index = 9 i = 11
            // [1,1,2,2,4,4,10,10,10,....]
        }
        return result;
    }

}

