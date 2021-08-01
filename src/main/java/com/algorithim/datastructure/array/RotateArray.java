package com.algorithim.datastructure.array;

public class RotateArray {
    public static void main(String[] args) {
        rotateWithExtraSpace(new int[]{1,2,3,4,5,6,7},3);
        rotateInPlaceReverse(new int[]{1,2,3,4,5,6,7},3);
        // rotateRightInPlace(new int[]{1,2,3,4,5,6,7},3);
    }

    private static void rotateInPlaceReverse(int[] nums, int n) {
        reverseInPlaceInt(nums, 0, nums.length - 1);
        reverseInPlaceInt(nums, 0, n - 1);
        reverseInPlaceInt(nums, n, nums.length - 1 - n);
        System.out.println();
    }

    private static void rotateRightInPlace(int[] nums, int n) {
        int sets = nums.length / n;
        for(int i=0;i<sets;i++){
            int oldIndex = i;
            int temp = 0;
            while(true){
                int newIndex = ( oldIndex + n ) % nums.length;
                if (newIndex == i) break;
                temp = nums[newIndex];
                nums[newIndex] = nums[oldIndex];
                oldIndex = newIndex;
            }
            nums[i] = temp;
        }
        System.out.println();
    }

    private static int [] reverseInPlaceInt(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums,start, end);
            start++;
            end--;
        }
        return nums;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void rotateWithExtraSpace(int[] nums, int k) {
        // Input: nums = [1,2,3,4,5,6,7], k = 3
        // Output: [5,6,7,1,2,3,4]
        int length = nums.length;
        int [] b = new int [length];
        for(int i=0;i<length;i++){
            int newIndex = ( i + k ) % length;
            b[newIndex] = nums[i];
        }
    }


}
