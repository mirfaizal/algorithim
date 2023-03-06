package com.algorithim.datastructure.ik.sorting;

public class MergeSort {
    public static void main(String args[]){
        int [] array = {9,6,4,3,1};
        array = mergeSort(array);
        for(int i : array)
        System.out.print(i+" ");
    }

    public static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        int mid = array.length / 2;
        int [] left = new int[mid];
        int [] right;
        if(array.length % 2 == 0){
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }
        for(int i = 0; i < mid; i++) left[i] = array[i];
        for(int i = 0; i < right.length; i++) right[i] = array[mid + i];

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);
    }

    private static int [] merge(int [] left, int [] right){
        int [] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while(leftIndex < left.length || rightIndex < right.length){
            if(leftIndex < left.length && rightIndex < right.length){
                if(left[leftIndex] < right[rightIndex]){
                    result[index++] = left[leftIndex++];
                } else {
                    result[index++] = right[rightIndex++];
                }
            } else if (leftIndex < left.length) {
                result[index++] = left[leftIndex++];
            } else {
                result[index++] = right[rightIndex++];
            }
        }
        return result;
    }
}
