package com.algorithim.datastructure.array;

public class KthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{-1,-1},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        return quickSort(nums, k, 0, nums.length - 1);
    }
    public static int quickSort(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return nums[nums.length - k];
        }
        int partition = partition(nums, left, right);
        if(partition == nums.length - k) return nums[partition];
        if ( partition > nums.length - k){
            quickSort(nums, k, left, partition - 1);
        } else {
            quickSort(nums, k, partition , right);
        }
        return nums[nums.length - k];
    }
    public static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int [] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
