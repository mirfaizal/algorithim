package com.algorithim.datastructure.sorting;

import java.util.Random;

public class KthLargestInArray {
    public static void main(String[] args) {
        int[] unSortedArray = new int[]{10, 16, 8, 12, 15, 6, 3, 9, 5};
        displayArray(unSortedArray);
        System.out.println(kthLargestInArray(unSortedArray, 0, unSortedArray.length - 1,6));
    }

    private static int kthLargestInArray(int[] arr, int start, int end, int k) {
        while(start < end){
            int partition = lomutosPartition(arr,start,end);
            if(partition == arr.length - k) return arr[partition];
            else if(partition < arr.length - k) start = partition + 1;
            else end = partition - 1;
        }
        return -1;
    }

    private static int lomutosPartition(int[] arr, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        swap(arr, pivotIndex, start);
        int orange = start;
        for(int green = start + 1; green < arr.length; green++){
            if(arr[green] < arr[start]){
                orange++;
                swap(arr,green,orange);
            }
        }
        swap(arr,start,orange);
        return orange;
    }

    private static void swap(int[] arr, int pivotIndex, int start) {
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[start];
        arr[start] = temp;
    }

    private static void displayArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) System.out.print(sortedArray[i] + " ");
        System.out.println();
    }
}
