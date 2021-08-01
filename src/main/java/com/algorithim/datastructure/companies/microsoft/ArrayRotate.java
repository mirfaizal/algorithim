package com.algorithim.datastructure.companies.microsoft;

public class ArrayRotate {
    public static void main(String[] args) {
        rotateLeft(new int[]{1,2,3,4,5},2);
        System.out.println();
        rotateRight(new int[]{1,2,3,4,5},2);
        System.out.println();
        rotateRightInPlace(new int[]{1,2,3,4,5},2);
    }

    private static void rotateLeft(int[] nums, int position) {
        int [] arr = new int[nums.length];
        for(var i=0;i<nums.length;i++){
            int newIndex = (i + position) % nums.length;
            arr[newIndex] = nums[i];
        }
        for(var i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }

    private static void rotateRight(int[] nums, int position) {
        int [] arr = new int[nums.length];
        for(var i=nums.length - 1;i>=0;i--){
            int newIndex = i - position % nums.length;
            if(i - position < 0) {
                newIndex = (i - position + nums.length) ;
            }
            arr[newIndex] = nums[i];
        }
        for(var i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
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
        for(var i=0;i<nums.length;i++) System.out.print(nums[i]+" ");
    }

    // 1 2 3 4 5 6    -- 2
    // 1 2 | 3 4 | 5 6
}
