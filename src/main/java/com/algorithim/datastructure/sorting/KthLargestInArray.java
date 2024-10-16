package com.algorithim.datastructure.sorting;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class KthLargestInArray {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        int[] unSortedArray = new int[]{5, 1, 10, 3, 2};
        displayArray(unSortedArray);
        System.out.println(quickSelect(unSortedArray, 0, unSortedArray.length - 1,2));
    }

    public static int quickSelect(int[] nums, int start, int end, int k) throws NoSuchAlgorithmException {
        if(start <= end) {
            Random rand = SecureRandom.getInstanceStrong();
            int pivot = rand.nextInt(end - start + 1) + start;
            int partition = partition(nums, start, end, pivot);
            if (k == partition) return nums[k];
            else if (partition > nums.length - k) return quickSelect(nums, start, partition - 1, k);
            return quickSelect(nums, partition + 1, end, k);
        }
        return -1;
    }

    public static int partition(int[] nums,int start, int end, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums,pivot_index, end);
        int orange = start;
        for (int green = start; green <= end; green++) {
            if (nums[green] < pivot) {
                swap(nums,orange, green);
                orange++;
            }
        }
        swap(nums,orange, end);
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

/*
Return Top View of binary tree.
      0
      1
     /   \
    2      3
  / \     /    \
 4   5,6   7
      \
       55
        \
         66
          \
            77

                           -2,-1,0,1,2,3  return (-2,3)
            return Top View[4, 2,1,3,7,77]
                   bottom view
                   column view[ [4],  [2], [1,5,6], [3,55], [7,66], [77]]  <==  simple
                   return {min_column_index, max_column_index) <==

   [1]
  [2 3]
[4,5,6,7]
   [55]
   [66]
   [77]
*/
