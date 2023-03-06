package com.algorithim.datastructure.sorting;

import java.util.Random;

public class KthLargestInStringArray {

    public static void main(String[] args) {
        String[] unSortedArray = new String[]{"2","21","12","1"};
        displayArray(unSortedArray);
        System.out.println(kthLargestNumber(unSortedArray, 1));
    }

    private static void displayArray(String[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) System.out.print(sortedArray[i] + " ");
        System.out.println();
    }

    public static String kthLargestNumber(String[] nums, int k) {
        int size = nums.length;
        return quickSelect(nums, 0 , size - 1, size - k);
    }
    public static String quickSelect(String[] nums, int start, int end, int k) {
        Random rand = new Random();
        int pivot = rand.nextInt(end - start + 1) + start;
        int partition = partition(nums,start, end, pivot);
        if (k == partition)return nums[k];
        else if (partition > k)
            return quickSelect(nums,start, partition - 1, k);
        return quickSelect(nums,partition + 1, end, k);
    }


    public static int partition(String[] nums, int start, int end, int pivotIndex) {
        String pivot = nums[pivotIndex];
        swap(nums,pivotIndex, end);
        int orange = start;
        for (int green = start; green <= end; green++) {
            if (smaller(nums[green] , pivot)) {
                swap(nums,orange, green);
                orange++;
            }
        }
        swap(nums,orange, end);
        return orange;
    }

    private static boolean smaller(String a, String b){
        if(a.length() < b.length()) return true;
        else if (a.length() > b.length()) return false;
        // Both are same length, need to check the ascii and compare
        return a.compareTo(b) < 0;
    }
    private static void swap(String[] nums, int a, int b){
        String temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
