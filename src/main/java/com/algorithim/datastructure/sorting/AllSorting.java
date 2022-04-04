package com.algorithim.datastructure.sorting;

import java.util.Collections;
import java.util.Random;

public class AllSorting {
    public static void main(String[] args) {
        int[] unSortedArray = new int[]{10, 9, 8, 5, 6, 3, 1, 2};
        int[] sortedArray;
        // sortedArray = selectionSort(unSortedArray);
        // displayArray(sortedArray);
        // sortedArray = bubbleSort(unSortedArray);
        // displayArray(sortedArray);
        // sortedArray = insertionSort(unSortedArray);
        // displayArray(sortedArray);
        // sortedArray = mergeSort(unSortedArray);
        // displayArray(sortedArray);
        unSortedArray = new int[]{10, 16, 8, 12, 15, 6, 3, 9, 5, 5, 10, 15, 13, 16};
//        quickSortLomutos(unSortedArray, 0, unSortedArray.length - 1);
//        displayArray(unSortedArray);
        quickSortLomutos(unSortedArray, 0, unSortedArray.length - 1);
        displayArray(unSortedArray);

    }
    private static void quickSortLomutosPartII(int[] array, int start, int end) {
        if(start < end){
            int partition = lomutosPartitionPartII(array,start,end);
            quickSortLomutosPartII(array,start, partition);
            quickSortLomutosPartII(array,partition + 1, end);
        }
    }

    private static int lomutosPartitionPartII(int[] array, int start, int end) {
        Random rand = new Random();
        int pivot = rand.nextInt(end - start + 1) + start;
        swap(array, pivot, start);
        int orange = start;
        for(int green = start + 1; green < array.length ; green++){
            if(array[green] < array[start]){
                orange++;
                swap(array,green,orange);
            }
        }
        swap(array,orange,start);
        return orange;
    }

    private static void displayArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) System.out.print(sortedArray[i] + " ");
        System.out.println();
    }

    private static int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    private static int[] bubbleSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private static int[] insertionSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        for (int i = 1; i < array.length; i++) {
            int hole = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > hole) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = hole;
        }
        return array;
    }

    private static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right;
        if (array.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }
        for (int i = 0; i < mid; i++) left[i] = array[i];
        for (int i = 0; i < right.length; i++) right[i] = array[mid + i];
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    result[index++] = left[leftIndex++];
                } else {
                    result[index++] = right[rightIndex++];
                }
            } else if (leftIndex < left.length) {
                result[index++] = left[leftIndex++];
            } else if (rightIndex < right.length) {
                result[index++] = right[rightIndex++];
            }
        }
        return result;
    }

    private static void quickSortLomutos(int[] array, int left, int right) {
        if (left < right) {
            int partition = quicksort_helper(array, left, right);
            quickSortLomutos(array, left, partition - 1);
            quickSortLomutos(array, partition + 1, right);
        }
    }

    public static int quicksort_helper(int[] array, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        swap(array, pivotIndex, end);
        int orange = start;
        for (int green = start; green < end ; green++) {
            if (array[green] <  array[end] || array[green] ==  array[end]) {
                swap(array, orange, green);
                orange++;
            }
        }
        swap(array, orange, end);
        return orange;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partition = partition(array, left, right);
            System.out.println(partition);
            quickSort(array, left, partition);
            quickSort(array, partition + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left, j = right;
        while (i < j) {
            do {
                i++;
            }
            while (array[i] < pivot && i < j);
            while (array[j] > pivot){
                j--;
            }
            if (i < j) swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
