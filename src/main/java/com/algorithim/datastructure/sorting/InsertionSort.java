package com.algorithim.datastructure.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        //is.insertionSort(new int [] {3,20,5,10,1,6});
        is.binaryInsertionSort(new int [] {3,20,5,10,1,6});
    }
    public int [] insertionSort(int [] numbers){
        for(int j = 1 ; j<numbers.length ;j++){
            int key = numbers[j];
            int i = j-1;
            while(i >= 0 && numbers[i] > key){
                numbers[i+1] =numbers[i];
                i= i-1;
            }
            numbers[i+1] = key;
            System.out.println("Iteration : " +j);
            for(int kk : numbers){
                System.out.print(kk+" ");
            }
            System.out.println("\n-------------------");
        }
        return numbers;
    }

    public int [] binaryInsertionSort(int [] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            int location = binarySearch(numbers, key, 0, j);
            while (j >= location ){
                numbers[j+1] =numbers[j];
                j = j -1 ;
            }
            numbers[j + 1] = key;
            System.out.println("Iteration : " +i);
            for(int kk : numbers){
                System.out.print(kk+" ");
            }
            System.out.println("\n-------------------");
        }
        return numbers;
    }

    private int binarySearch(int[] numbers, int key, int i, int j) {
        while(i<j){
            int mid = i + (j - i) / 2;
            if(numbers[mid] > key){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return i;
    }

    }
