package com.algorithim.datastructure.array;

public class Reverse {
    public static void main(String[] args) {
        int [] array = reverse(new int [] {1,2,3,4,5});
        for(int i : array) System.out.print(i+" ");
    }

    private static int[] reverse(int[] nums) {
        if(nums.length == 0) return new int [] {};
        int[] reverse = new int [nums.length];
        int index = 0;
        for(int i=nums.length - 1 ; i>=0; i--){
            reverse[index++] = nums[i];
        }
        return reverse;
    }
}
