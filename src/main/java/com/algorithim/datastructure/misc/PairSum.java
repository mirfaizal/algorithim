package com.algorithim.datastructure.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    static int contigiousSum(int[] arr, int k) {
        int maxGlobal = arr[0], maxCurrent= arr[0];
        for(int i=1;i<arr.length;i++){
            maxCurrent = Math.max(arr[i],maxCurrent + arr[i]);
            if(maxGlobal < maxCurrent) maxGlobal = maxCurrent;
        }
        return maxGlobal;
    }

    static int numberOfWays(int[] arr, int k) {
        int numberOfMatch = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int difference = k - arr[i];
            if(map.containsKey(difference)){
                numberOfMatch += map.get(difference);
                map.put(arr[i], map.get(difference) + 1);
            } else{
                map.put(arr[i], 1);
            }
        }
        return numberOfMatch;
    }

    private static int sumsToTarget(int[] arr, int k) {
        Arrays.sort(arr);
        int numberOfMatch = 0;
        int lhs = 0;
        int rhs = arr.length - 1;
        while (lhs < rhs) {
            int sum = arr[lhs] + arr[rhs];
            if (sum == k) {numberOfMatch += 1; lhs++; rhs--;}
            else if (sum < k) lhs++;
            else rhs--;
        }
        return numberOfMatch;
    }

    public static void main(String[] args) {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    static int test_case_number = 1;

    static void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    static void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
}
