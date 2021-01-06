package com.algorithim.datastructure.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        is.insertionSort1(5,new int[]{2,4,6,8,3});
    }

    /**
    Insert element into sorted list
    Given a sorted list with an unsorted number  in the rightmost cell, can you write some simple code to insert  into the array so that it remains sorted?
    Since this is a learning exercise, it won't be the most efficient way of performing the insertion. It will instead demonstrate the brute-force method in detail.
    Assume you are given the array  indexed . Store the value of . Now test lower index values successively from  to  until you reach a value that is lower than , at  in this case. Each time your test fails, copy the value at the lower index to the current index and print your array. When the next lower indexed value is smaller than , insert the stored value at the current index and print the entire array.
    Example
    Start at the rightmost index. Store the value of . Compare this to each element to the left until a smaller value is reached. Here are the results as described:
            1 2 4 5 5
            1 2 4 4 5
            1 2 3 4 5
    */
    public void insertionSort1(int n, int[] arr) {
        int i = n-2;
        int key = arr[n-1];
        while(i >= 0 && arr[i] > key ){
            arr[i+1] = arr[i];
            print(n, arr);
            i--;
        }
        arr[i+1] = key;
        print(n, arr);
    }

    private void print(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int value = numbers[i];
            int index = i - 1;
            while (index >= 0 && numbers[index] > value) {
                numbers[index + 1] = numbers[index];
                index --;
            }
            numbers[index + 1] = value;
        }
        return numbers;
    }

    public int[] binaryInsertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            int location = binarySearch(numbers, key, 0, j);
            while (j >= location) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
        }
        return numbers;
    }

    private int binarySearch(int[] numbers, int key, int i, int j) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] > key) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

}
