package com.algorithim.datastructure.sorting;

public class GroupNumbers {
    public static void main(String[] args) {
        int arr [] = groupNumbers(new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9});
        for (int i : arr) System.out.print(i+" ");
    }

    private static int[] groupNumbers(int [] arr) {
        int  even = 0, odd = arr.length - 1;
        while(even < odd){
            if(arr[even] % 2 != 0){
                swap(arr, even, odd);
                odd--;
            } else {
                even++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int even, int odd) {
        int temp = arr[even];
        arr[even] = arr[odd];
        arr[odd] = temp;
    }
}
