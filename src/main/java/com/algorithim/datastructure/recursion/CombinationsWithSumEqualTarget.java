package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsWithSumEqualTarget {
//    Given an integer array, generate all the unique combinations of the array numbers that sum up to a given target value.
//    Example One:
//    Input: [1, 2, 3], 3
//    Output: [ [1, 2], [3] ]
//    Example Two:
//    Input: [1, 1, 1, 1], 2
//    Output: [ [1, 1] ]
    public static void main(String[] args) {
        List<List<Integer>> result =  generate_all_combinations(new ArrayList<>(Arrays.asList(1,1,1,1)),2);
        for(List<Integer> list : result) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        if(arr.isEmpty()) return result;
        Collections.sort(arr);
        generate_all_combinations(arr,target,0,0,new ArrayList<>());
        return result;
    }

    private static void generate_all_combinations(List<Integer> arr, int target, int sum,int index, List<Integer> slate) {
        // Backtrack case
        if(sum > target) return;
        else if(sum == target) {
            result.add(new ArrayList<>(slate));
            return;
        }
        // Base Case
        if(index == arr.size()) return;

        // Recursive case
        // Get the count of the duplicates
        int count = 0;
        for(int i=index;i<arr.size();i++){
            if(!arr.get(i).equals(arr.get(index))) break;
            count++;
        }
        // Exclude
        generate_all_combinations(arr,target,sum,index + count, slate);

        // Multiway inclusion
        for(int i=0;i<count;i++){
            slate.add(arr.get(index));
            sum = sum + arr.get(index);
            generate_all_combinations(arr,target,sum ,index + count, slate);
        }
        // Clear the slate
        for(int i=0;i<count;i++){
            slate.remove(slate.size() - 1);
            sum = sum - arr.get(index);
        }
    }
}
