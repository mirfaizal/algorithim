package com.algorithim.datastructure.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(bruteForce(new int[] {5,10,10,10,5}, 10));
        System.out.println(presortingAndBinarySearch(new int[] {5,10,10,10,5}, 20));
        System.out.println(presortingAndTwoPointer(new int[] {5,10,10,10,5}, 10));
        System.out.println(hashTable(new int[] {5,10,10,10,5}, 10));
    }

    private static boolean hashTable(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(target - arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
    }

    private static boolean bruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) return true;
            }
        }
        return false;
    }

    private static boolean presortingAndTwoPointer(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while(i < j){
            if(arr[i] + arr[j] == target) return true;
            else if(arr[i] + arr[j] > target) j--;
            else if(arr[i] + arr[j] < target) i++;
        }
        return false;
    }

    private static boolean presortingAndBinarySearch(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int siblingIndex = Arrays.binarySearch(arr, k - arr[i]);
            if (siblingIndex >= 0) { // Found it!
                /* If this points at us, then the pair exists only if
                 * there is another copy of the element. Look ahead of
                 * us and behind us.
                 */
                if (siblingIndex != i || (i > 0 && arr[i-1] == arr[i]) || (i < arr.length - 1 && arr[i+1] == arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
