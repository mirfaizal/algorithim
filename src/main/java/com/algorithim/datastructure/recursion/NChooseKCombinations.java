package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class NChooseKCombinations {
//    Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.
//    Example One:
//    Input: 5, 2
//    Output: [[1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]].
//    Example Two:
//    Input: 6, 6
//    Output: [[1, 2, 3, 4, 5, 6]].

    public static void main(String[] args) {
        List<List<Integer>> results = find_combinations(5,5);
        for(List<Integer> list : results) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
    static List<List<Integer>> results = new ArrayList<>();
    public static List<List<Integer>> find_combinations(int n, int k) {
        int [] nums = new int[n];
        int index = 0;
        for(int i = 1; i <= n ; i++) nums[index++] = i;
        find_combinations(nums,0,new ArrayList<>(),k);
        return results;
    }

    private static void find_combinations(int[] nums, int index, ArrayList<Integer> slate, int k) {
        // Backtrack case
        if(slate.size() == k){
            results.add(new ArrayList<>(slate));
            return;
        }
        // Base Case
        if(index == nums.length){
            return;
        }
        // Recursive case
        // Exclude
        find_combinations(nums,index+1,slate,k);
        // Include
        slate.add(nums[index]);
        find_combinations(nums,index+1,slate,k);
        slate.remove(slate.size() - 1);
    }
}
