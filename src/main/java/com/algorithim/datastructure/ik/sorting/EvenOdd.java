package com.algorithim.datastructure.ik.sorting;

/**
 * Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.
 * Input : [1, 2, 3, 4]
 * Output: [4, 2, 3, 1]
 */

public class EvenOdd {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4,5,6,7,8,9};
        int [] solution = evenOdd(array);
        for (int i : solution){
            System.out.print(i+" ");
        }

    }

    private static int[] evenOdd(int[] array) {
        int evenIndex = 0;
        int oddIndex = array.length - 1;
        while(evenIndex < oddIndex){
            if(array[evenIndex] % 2 == 0) evenIndex++;
            else {
                swap(array,evenIndex,oddIndex);
                oddIndex--;
            }
        }
        return array;
    }

    private static void swap(int[] array, int evenIndex, int oddIndex) {
        int temp = array[evenIndex];
        array[evenIndex] = array[oddIndex];
        array[oddIndex] = temp;
    }
}
