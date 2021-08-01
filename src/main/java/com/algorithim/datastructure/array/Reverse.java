package com.algorithim.datastructure.array;

public class Reverse {
    public static void main(String[] args) {
        int [] array = reverse(new int [] {1,2,3,4,5});
        for(int i : array) System.out.print(i+" ");
        System.out.println(reverseInPlaceString("abcdef"));
    }

    private static String reverseInPlaceString(String str) {
        char [] charArray = str.toCharArray();
        int start=0, end=charArray.length - 1;
        while (start < end) {
            swap(charArray,start, end);
            start++;
            end--;
        }
        return new String(charArray);
    }

    private static void swap(char[] charArray, int start, int end) {
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
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
