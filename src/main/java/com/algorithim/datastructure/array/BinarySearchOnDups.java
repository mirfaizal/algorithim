package com.algorithim.datastructure.array;

import java.util.Arrays;

public class BinarySearchOnDups {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 9, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 9, 10}, 11)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int start = 0 , end = nums.length;
        // Find end position.
        while(start < end){
            int mid = start + ((end - start) / 2);
            if(nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int newStart = start;
        if(newStart -1 == -1 || nums[newStart] != target) return new int[]{-1,-1};
        start = 0;
        end = nums.length;
        while(start < end){
            int mid = start + ((end - start) / 2);
            if(nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{newStart,end};
    }

}
