package com.algorithim.datastructure.array;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0,1,2,3,4,5,6,7,8,9},7));
    }

    private static int binarySearch(int[] arr, int number) {
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + ((end - start) / 2);
            if(arr[mid] == number) return mid;
            else if(arr[mid] > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
