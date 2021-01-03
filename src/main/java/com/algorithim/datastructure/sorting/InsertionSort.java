package com.algorithim.datastructure.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] array = is.insertionSort(new int[]{8, 4, 3, 9, 1, 7, 2, 5, 6});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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
