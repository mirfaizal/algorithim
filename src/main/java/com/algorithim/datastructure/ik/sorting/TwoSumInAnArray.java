package com.algorithim.datastructure.ik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array and a target number, find the indices of the two values from the array that sum up to the given target number.
 *
 * Example One
 * {
 * "numbers": [5, 3, 10, 45, 1],
 * "target": 6
 * }
 * Output:
 *
 * [0, 4]
 * Sum of the elements at index 0 and 4 is 6.
 *
 * Example Two
 * {
 * "numbers": [4, 1, 5, 0, -1],
 * "target": 10
 * }
 * Output:
 *
 * [-1, -1]
 */
public class TwoSumInAnArray {
    public static void main(String[] args) {
        List<Integer> result = twoSum(Arrays.asList(5, 3, 10, 45, 1),51);
        result.forEach(item -> System.out.print(item + " "));
    }

    public static List<Integer> twoSum(List<Integer> numbers, int target) {
        List<Integer> result = new ArrayList<>();
        // If I sort,  n log n then I can use 2 pointer approach
        // Time -> O(nlog(n))
        // Space -> Constant
        // If I use, additional space I can do this in Time - o(n), Space - o(n)
        // 5, 3, 10, 45, 1 --- 6
        // <5, 0>, <3,1>, <10,2>, <45, 4>, <>

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < numbers.size(); i++) {
            int difference = target - numbers.get(i);
            if(map.get(difference) != null) {
                result.add(map.get(difference));
                result.add(i);
                return result;
            }
            map.put(numbers.get(i),i);
        }
        result = Arrays.asList(-1,-1);
        return result;
    }
}
