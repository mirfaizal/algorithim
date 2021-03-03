package com.algorithim.datastructure.sorting;

public class AllSorting {
    public static void main(String[] args) {
        int [] unSortedArray = new int [] {10,9,8,5,6,3,1,2};
        int [] sortedArray = new int[unSortedArray.length];
        sortedArray = selectionSort(unSortedArray);
        displayArray(sortedArray);
        sortedArray = bubbleSort(unSortedArray);
        displayArray(sortedArray);

    }

    private static void displayArray(int[] sortedArray) {
        for(int i=0;i<sortedArray.length;i++) System.out.print(sortedArray[i]+" ");
        System.out.println();
    }

    private static int[] selectionSort(int[] array) {
        if(array ==null || array.length <= 1) return array;
        for(int i=0;i<array.length;i++) {
            int min = array[i];
            int minIndex = i;
            for(int j=i+1;j<array.length;j++) {
                if(min > array[j]){
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

    private static int[] bubbleSort(int [] array){
        if(array ==null || array.length <= 1) return array;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private static int[] insertionSort(int [] array){
        if(array ==null || array.length <= 1) return array;
        for(int i=0;i<array.length;i++){

        }
        return array;
    }


}
