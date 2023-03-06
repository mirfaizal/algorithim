package com.algorithim.datastructure.ik.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Given an array of integers, find the k-th largest number in it.
 *
 * Example One
 * {
 * "numbers": [5, 1, 10, 3, 2],
 * "k": 2
 * }
 * Output: 5
 *
 * Example Two
 * {
 * "numbers": [4, 1, 2, 2, 3],
 * "k": 4
 * }
 * Output: 2
 *
 * Notes Constraints:
 *
 * 1 <= array size <= 3 * 105
 * -109 <= array elements <= 109
 * 1 <= k <= array size
 */
public class KthLargestInArray {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 1, 10, 3, 2,4,6);
        System.out.print(kthLargestInAnArray(list,0,list.size() - 1,3));
    }
    public static int kthLargestInAnArray(List<Integer> numbers, int start, int end, int k) {
        if(start <= end) {
            int partition = partition(numbers, start, end);
            if (partition ==  k) return numbers.get(k);
            else if (partition > k) {
                return kthLargestInAnArray(numbers, start, partition - 1, k);
            } else {
                return kthLargestInAnArray(numbers, partition + 1, end, k);
            }
        }
        return -1;
    }

    private static int partition(List<Integer> numbers, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        swap(numbers,pivotIndex,start);
        int orange = start;
        for(int green = start + 1; green <numbers.size(); green++){
            if(numbers.get(green) < numbers.get(start)) {
                swap(numbers,orange,green);
                orange++;

            }
        }
        swap(numbers,orange,start);
        return orange;

    }

    private static void swap(List<Integer> numbers, int i, int j){
        Integer temp = numbers.get(i);
        numbers.set(i,numbers.get(j));
        numbers.set(j,temp);
    }
}
