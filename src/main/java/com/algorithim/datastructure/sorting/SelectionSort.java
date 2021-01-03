package com.algorithim.datastructure.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 3, 9, 1, 7, 2, 5, 6};
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void selectionSort(int[] array) {
        for(int i=0; i<array.length-1; i++){
            int min = array[i];
            int minIndex = i;
            for(int j=i+1; j<array.length;j++){
                if(min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
