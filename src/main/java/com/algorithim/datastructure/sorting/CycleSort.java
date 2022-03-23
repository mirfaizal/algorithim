package com.algorithim.datastructure.sorting;

import static com.algorithim.datastructure.array.KthLargest.swap;

public class CycleSort {
    public static void main(String[] args) {
        cycleSort(new int [] {17,19,13,7,1,5,15,11,9,3,21});
    }

    private static int [] cycleSort(int[] arr) {
        int left = 0; int right = arr.length - 1;
        while(left < right){
            while(rank(arr[left],arr) != left){
                int rank = rank(arr[left],arr);
                swap(arr, rank, left);
            }
            left++;
        }
        for(int i=-0;i< arr.length;i++) System.out.print(arr[i]+" , ");
        return arr;
    }

    private static int rank(int num, int arr []) {
        int rank = 0;
        for(int i=-0;i< arr.length;i++){
            if(arr[i] < num) rank++;
        }
        return rank;
    }
}
