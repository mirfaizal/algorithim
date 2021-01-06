package com.algorithim.datastructure.sorting;

public class InsertionSortRevised {
    public static void main(String[] args) {
        InsertionSortRevised is = new InsertionSortRevised();
        int[] array = is.insertionSort(new int[]{8, 4, 3, 9, 1, 7, 2, 5, 6});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private int[] insertionSort(int[] array) {
        for(int i=1 ;i<array.length; i++){
            int value = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > value){
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = value;
        }
        return array;
    }
}
