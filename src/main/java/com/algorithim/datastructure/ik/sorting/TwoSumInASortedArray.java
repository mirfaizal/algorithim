package com.algorithim.datastructure.ik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array sorted in non-decreasing order and a target number, find the indices of the two values from the array that sum up to the given target number.
 *
 * Example
 * {
 * "numbers": [1, 2, 3, 5, 10],
 * "target": 7
 * }
 * Output:
 *
 * [1, 3]
 * Sum of the elements at index 1 and 3 is 7.
 *
 * Notes
 * In case when no answer exists, return an array of size two with both values equal to -1, i.e., [-1, -1].
 * In case when multiple answers exist, you may return any of them.
 * The order of the indices returned does not matter.
 * A single index cannot be used twice.
 * Constraints:
 *
 * 2 <= array size <= 105
 * -105 <= array elements <= 105
 * -105 <= target number <= 105
 * Array can contain duplicate elements.
 */
public class TwoSumInASortedArray {
    public static void main(String[] args) {
        List<Integer> result = pairSumSortedArray(Arrays.asList(1, 2, 3, 5, 10),81);
        result.forEach(item -> System.out.print(item + " "));
    }
    public static List<Integer> pairSumSortedArray(List<Integer> numbers, int target) {
        int start = 0;
        int end = numbers.size() - 1;
        List<Integer> result = new ArrayList<>();
        while(start <= end) {
            if(numbers.get(start) + numbers.get(end) == target) {
                result.add(start);
                result.add(end);
                return result;
            } else if (numbers.get(start) + numbers.get(end) > target) {
                end--;
            } else {
                start++;
            }
        }
        result = Arrays.asList(-1,-1);
        return result;
    }
}
