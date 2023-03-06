package com.algorithim.datastructure.ik.sorting;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int [] array = new int[] {90, 91, 4,6,8,2,1,56,3,78,90,0,91,0,5,7,52};
        quickSort(array,0,array.length-1);
        for(int i : array) System.out.print(i+" ");
    }
    private static void quickSort(int [] array, int start, int end){
        if(start < end) {
            int partition = quickShotHelper(array,start,end);
            quickSort(array,start,partition);
            quickSort(array,partition + 1,end);
        }
    }

    private static int quickShotHelper(int[] array, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        swap(array,pivotIndex,start);
        int orange = start;
        for(int green = start + 1; green < array.length; green++){
            if(array[green] < array[start]) {
                orange++;
                swap(array,orange,green);

            }
        }
        swap(array,orange,start);
        return orange;
    }

    private static void swap(int[] array, int evenIndex, int oddIndex) {
        int temp = array[evenIndex];
        array[evenIndex] = array[oddIndex];
        array[oddIndex] = temp;
    }
}
