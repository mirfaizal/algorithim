package com.algorithim.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    public static void main(String[] args) {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int [] array = arrayIntersection.intersection(new int[] {1,2,3,1} , new int[] {2,3,1});
        for(int n : array){
            System.out.println(n);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int i=0, j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> hashset = new HashSet<Integer>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                hashset.add(nums1[i]);
                i++;
            }
        }
        int [] resultArray = new int[hashset.size()];
        int index = 0;
        for(int value: hashset){
            resultArray[index++] = value;
        }
        return resultArray;
    }
}
