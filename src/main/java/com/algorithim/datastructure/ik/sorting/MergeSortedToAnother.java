package com.algorithim.datastructure.ik.sorting;


/**
 * First array has n positive numbers, and they are sorted in the non-descending order.
 * Second array has 2n numbers: first n are also positive and sorted in the same way but the last n are all zeroes.
 * Merge the first array into the second and return the latter. You should get 2n positive integers sorted in the non-descending order.
 *
 * Example
 * {
 * "first": [1, 3, 5],
 * "second": [2, 4, 6, 0, 0, 0]
 * }
 * Output:
 *
 * [1, 2, 3, 4, 5, 6]
 */
public class MergeSortedToAnother {
    public static void main(String[] args) {
        merger_first_into_second(new int[] {1, 3, 5}, new int[] {2, 4, 6, 0, 0, 0});
    }

    static void merger_first_into_second(int[] arr1, int[] arr2) {
        // [2, 4, 6, 0, 0, 0]
        // [2, 4, 6, 0, 0, 6]
        // [2, 4, 6, 0, 5, 6]
        // [2, 4, 6, 4, 5, 6]
        // [1, 2, 3, 4, 5, 6]
        int arr1Index = arr1.length - 1;
        int arr2Index = arr1.length - 1;
        int index = arr2.length - 1;
        while(arr1Index >= 0 || arr2Index >=0) {
            if(arr1Index >= 0 && arr2Index >=0) {
                if (arr1[arr1Index] > arr2[arr2Index]) {
                    arr2[index--] = arr1[arr1Index--];
                } else {
                    arr2[index--] = arr2[arr2Index--];
                }
            } else if(arr1Index >= 0) {
                arr2[index--] = arr1[arr1Index--];
            } else {
                arr2[index--] = arr2[arr2Index--];
            }
        }
        for(int i : arr2) System.out.print(i+" ");
    }
}
