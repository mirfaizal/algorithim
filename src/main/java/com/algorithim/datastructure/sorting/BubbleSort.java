package com.algorithim.datastructure.sorting;

public class BubbleSort {

    public int [] bubbleSort(int [] array){
        int length = array.length;
        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
