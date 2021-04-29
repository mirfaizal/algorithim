package com.algorithim.datastructure.sorting;

public class MergeSortedArrayIntoAnother {
//    Merge One Sorted Array Into Another
//    Given two arrays:
//    1) arr1 of size n, which contains n positive integers sorted in the ascending order.
//    2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order
//    in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).
//    Write a function that takes these two arrays, and merges the first one into second one, resulting in an
//    increasingly sorted array of (2*n) positive integers.
//
//    Example
//    Input:
//    n = 3
//    arr1 = [1 3 5]
//    arr2 = [2 4 6 0 0 0]
//    Output: arr2 = [1 2 3 4 5 6]

    public static void main(String[] args) {
        int arr [] = new int[]{2,4,6,0,0,0};
        merger_first_into_second(new int[]{1,3,5},arr);
        for (int i : arr) System.out.print(i+" ");
    }
    static void merger_first_into_second(int[] leftArray, int[] rightArray) {
        int left = leftArray.length - 1, right = leftArray.length - 1, n = rightArray.length - 1;
        while(left >= 0 || right >= 0){
            if(left >= 0 && right >= 0){
                if(leftArray[left] > rightArray[right]){
                    rightArray[n--] = leftArray[left--];
                } else {
                    rightArray[n--] = rightArray[right--];
                }
            } else if (left >= 0){
                rightArray[n--] = leftArray[left--];
            } else {
                rightArray[n--] = rightArray[right--];
            }
        }
    }

}
