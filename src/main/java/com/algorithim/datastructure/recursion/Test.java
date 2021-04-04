package com.algorithim.datastructure.recursion;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        System.out.print(check_if_sum_possible(new long[]{-1800000000,1800000000},0));
    }

    private static boolean result = false;
    static boolean check_if_sum_possible(long[] arr, long k) {

        Arrays.sort(arr);
        check_if_sum_possible(0, Long.valueOf(k), arr, k, 0);
        return result;

    }

    private static void check_if_sum_possible(int index, Long runningSum,long[] problemDefinition, Long target, int size) {
        // Backtrack case
        if(result) return;
        else if(runningSum == target && size > 0) {
            result = true;
            return;
        }
        // Base Case
        if(index == problemDefinition.length) return;
        // Recursive Case
        int count = 0;
        for(int i=index; i< problemDefinition.length; i++){
            if(problemDefinition[index] != problemDefinition[i]) break;
            count++;
        }
        // Exclude
        check_if_sum_possible(index + count, runningSum, problemDefinition, target, size);
        // Multi way Include
        for(int i = 0; i < count; i++){
            runningSum = runningSum - problemDefinition[index];
            check_if_sum_possible(index + count, runningSum , problemDefinition, target, size + 1);
        }
        for(int i = 0; i < count; i++){
            runningSum = runningSum + problemDefinition[index];
        }
    }
}
