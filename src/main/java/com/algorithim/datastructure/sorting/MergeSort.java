package com.algorithim.datastructure.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = mergeSort(new int[]{8, 4, 3, 9, 1, 7, 2, 5, 6});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray;
        if (array.length % 2 == 0) {
            rightArray = new int[middle];
        } else {
            rightArray = new int[middle + 1];
        }
        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = array[middle + j];
        }
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int left = 0, right = 0, result = 0;
        int[] resultArray = new int[leftArray.length + rightArray.length];
        while (left < leftArray.length || right < rightArray.length) {
            if (left < leftArray.length && right < rightArray.length) {
                if (leftArray[left] < rightArray[right]) {
                    resultArray[result++] = leftArray[left++];
                } else {
                    resultArray[result++] = rightArray[right++];
                }
            } else if (left < leftArray.length) {
                resultArray[result++] = leftArray[left++];
            } else if (right < rightArray.length) {
                resultArray[result++] = rightArray[right++];
            }
        }
        return resultArray;
    }
}
